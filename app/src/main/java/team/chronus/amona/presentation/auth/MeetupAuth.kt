package team.chronus.amona.presentation.auth

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import net.smartam.leeloo.client.OAuthClient
import net.smartam.leeloo.client.URLConnectionClient
import net.smartam.leeloo.client.request.OAuthClientRequest
import net.smartam.leeloo.common.exception.OAuthProblemException
import net.smartam.leeloo.common.exception.OAuthSystemException
import net.smartam.leeloo.common.message.types.GrantType
import team.chronus.amona.data.local.prefs.PreferencesHelper

/**
 * Created by yung on 7/24/17.
 */

class MeetupAuth : Activity() {
    private val TAG = javaClass.name

    private var _webview: WebView? = null
    private var _intent: Intent? = null
    private var _context: Context? = null

    internal var mPref: PreferencesHelper? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)

        _intent = intent
        _context = applicationContext

        _webview = WebView(this)
        _webview?.setWebViewClient(MyWebViewClient())
        setContentView(_webview)

        _webview?.settings?.javaScriptEnabled = true
        var request: OAuthClientRequest? = null
        try {
            request = OAuthClientRequest.authorizationLocation(
                    AUTH_URL).setClientId(
                    CONSUMER_KEY).setRedirectURI(
                    REDIRECT_URI).buildQueryMessage()
        } catch (e: OAuthSystemException) {
            Log.d(TAG, "OAuth request failed", e)
        }
        _webview?.loadUrl(request?.locationUri + "&response_type=code&set_mobile=on")
    }

    fun finishActivity() {
        finish()
    }

    private inner class MyWebViewClient : WebViewClient() {
        @Suppress("OverridingDeprecatedMember")
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            val uri = Uri.parse(url)

            val code = uri.getQueryParameter("code")
            val error = uri.getQueryParameter("error")

            if (code != null) {
                MeetupRetrieveAccessTokenTask().execute(uri)
            } else if (error != null) {
                setResult(Activity.RESULT_CANCELED, _intent)
                finishActivity()
            }
            return false
        }
    }

    private inner class MeetupRetrieveAccessTokenTask : AsyncTask<Uri, Void, Void>() {

        override fun doInBackground(vararg params: Uri): Void? {

            val uri = params[0]
            val code = uri.getQueryParameter("code")

            var request: OAuthClientRequest? = null

            try {
                request = OAuthClientRequest.tokenLocation(TOKEN_URL)
                        .setGrantType(GrantType.AUTHORIZATION_CODE).setClientId(
                        CONSUMER_KEY).setClientSecret(
                        CONSUMER_SECRET).setRedirectURI(
                        REDIRECT_URI).setCode(code)
                        .buildBodyMessage()

                val oAuthClient = OAuthClient(URLConnectionClient())

                val response = oAuthClient.accessToken(request)

                _intent?.putExtra("access_token", response.accessToken)
                _intent?.putExtra("refresh_token", response.refreshToken)
                _intent?.putExtra("expires_in", response.expiresIn)
                setResult(Activity.RESULT_OK, _intent)

                finish()
            } catch (e: OAuthSystemException) {
                Log.e(TAG, "OAuth System Exception - Couldn't get access token: " + e.toString())
                Toast.makeText(_context, "OAuth System Exception - Couldn't get access token: " + e.toString(), Toast.LENGTH_LONG).show()
            } catch (e: OAuthProblemException) {
                Log.e(TAG, "OAuth Problem Exception - Couldn't get access token")
                Toast.makeText(_context, "OAuth Problem Exception - Couldn't get access token", Toast.LENGTH_LONG).show()
            }

            return null
        }
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED, _intent)
        finishActivity()
    }

    companion object {
        val AUTH_URL = "https://secure.meetup.com/oauth2/authorize"
        val TOKEN_URL = "https://secure.meetup.com/oauth2/access"
        val REDIRECT_URI = "meetup.com"
        val CONSUMER_KEY = "7a08enc92nj1usddq6lbbuh2ua"
        val CONSUMER_SECRET = "tbavgvqsrotihbi1tuu9glgt4j"

        private val TAG = javaClass.name

        private var _webview: WebView? = null
        private var _intent: Intent? = null
        private var _context: Context? = null

        internal var mPref: PreferencesHelper? = null
    }
}