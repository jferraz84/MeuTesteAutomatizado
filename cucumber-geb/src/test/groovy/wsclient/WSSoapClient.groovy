package wsclient

import wslite.soap.SOAPClient
import wslite.http.auth.HTTPBasicAuthorization
import javax.xml.ws.soap.SOAPFaultException
import wslite.soap.SOAPClientException
import wslite.http.HTTP.*

import groovy.xml.*

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.security.MessageDigest;
import java.security.SecureRandom;
import sun.misc.BASE64Encoder;
import java.util.Base64.Encoder;
import groovy.time.TimeCategory
import groovy.util.Node

import ws.Payloads

@Mixin(Payloads)
class WSSoapClient{

  def authorization(username, password){
    SecureRandom rand = SecureRandom.getInstance("SHA1PRNG");
    rand.setSeed(System.currentTimeMillis());
    byte[] nonceBytes = new byte[16];
    rand.nextBytes(nonceBytes);

    //Make the created date
    def current = new Date()
    use( TimeCategory ) {
        current = current + 3.hours
    }
    String createdDate = current.format("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    byte[] createdDateBytes = createdDate.getBytes("UTF-8");

    //Make the password
    byte[] passwordBytes = password.getBytes("UTF-8");

    //SHA-1 hash the bunch of it.
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    baos.write(nonceBytes);
    baos.write(createdDateBytes);
    baos.write(passwordBytes);
    MessageDigest md = MessageDigest.getInstance("SHA-1");
    byte[] digestedPassword = md.digest(baos.toByteArray());

    //Encode the password and nonce for sending
    String passwordB64 = (new BASE64Encoder()).encode(digestedPassword);
    String nonceB64 = (new BASE64Encoder()).encode(nonceBytes);
    def authorization = populatePayload("security", [username:username, passwordB64:passwordB64, nonceB64:nonceB64, createdDate:createdDate])
    authorization
  }
}
