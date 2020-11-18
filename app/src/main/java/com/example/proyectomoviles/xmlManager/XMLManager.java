package com.example.proyectomoviles.xmlManager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.StrictMode;
import android.widget.Toast;

import com.example.proyectomoviles.productos.Bebida;
import com.example.proyectomoviles.productos.ItemCatalogoSalsaQuesadilla;
import com.example.proyectomoviles.productos.ItemCatalogoSalsaTaco;
import com.example.proyectomoviles.productos.ItemCatalogoTipoBebida;
import com.example.proyectomoviles.productos.Quesadilla;
import com.example.proyectomoviles.productos.Taco;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XMLManager {


    public static ArrayList<Taco> descargar_lista_tacos (Context context){
        String URL_lista_tacos = "https://examenmoviles.000webhostapp.com/tacos.xml";
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        ArrayList<Taco> arrayTacos = null;

        if (networkInfo != null && networkInfo.isConnected()){
            //Toast.makeText(context, "Conexion ok", Toast.LENGTH_SHORT).show();
            arrayTacos = descargar_lista_tacos_interna(URL_lista_tacos);
        }else{
            //Toast.makeText(context, "Conexion error", Toast.LENGTH_SHORT).show();
        }
        return arrayTacos;
    }


    public static ArrayList<Quesadilla> descargar_lista_quesadillas(Context context){
        String URL_lista_quesadillas = "https://examenmoviles.000webhostapp.com/quesadillas.xml";
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        ArrayList<Quesadilla> arrayQuesadillas = null;

        if (networkInfo != null && networkInfo.isConnected()){
            //Toast.makeText(context, "Conexion ok", Toast.LENGTH_SHORT).show();
            arrayQuesadillas = descargar_lista_quesadillas_interna(URL_lista_quesadillas);
        }else{
            //Toast.makeText(context, "Conexion error", Toast.LENGTH_SHORT).show();
        }
        return arrayQuesadillas;
    }


    public static ArrayList<Bebida> descargar_lista_bebidas(Context context){
        String URL_lista_bebidas = "https://examenmoviles.000webhostapp.com/bebidas.xml";
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        ArrayList<Bebida> arrayBebidas = null;

        if (networkInfo != null && networkInfo.isConnected()){
            //Toast.makeText(context, "Conexion ok", Toast.LENGTH_SHORT).show();
            arrayBebidas = descargar_lista_bebidas_interna(URL_lista_bebidas);
        }else{
            //Toast.makeText(context, "Conexion error", Toast.LENGTH_SHORT).show();
        }
        return arrayBebidas;
    }


    public static ArrayList<ItemCatalogoSalsaTaco> descargar_catalogosalsataco(Context context){
        String URL_catalogo_salsataco = "https://examenmoviles.000webhostapp.com/catalogosalsataco.xml";
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        ArrayList<ItemCatalogoSalsaTaco> arrayCatalogoSalsaTaco = null;

        if (networkInfo != null && networkInfo.isConnected()){
            //Toast.makeText(context, "Conexion ok", Toast.LENGTH_SHORT).show();
            arrayCatalogoSalsaTaco = descargar_catalogosalsataco_interna(URL_catalogo_salsataco);
        }else{
            //Toast.makeText(context, "Conexion error", Toast.LENGTH_SHORT).show();
        }
        return arrayCatalogoSalsaTaco;
    }


    public static ArrayList<ItemCatalogoSalsaQuesadilla> descargar_catalogosalsaquesadilla(Context context){
        String URL_catalogo_salsaquesadilla = "https://examenmoviles.000webhostapp.com/catalogosalsaquesadilla.xml";
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        ArrayList<ItemCatalogoSalsaQuesadilla> arrayCatalogoSalsaQuesadilla = null;

        if (networkInfo != null && networkInfo.isConnected()){
            //Toast.makeText(context, "Conexion ok", Toast.LENGTH_SHORT).show();
            arrayCatalogoSalsaQuesadilla = descargar_catalogosalsaquesadilla_interna(URL_catalogo_salsaquesadilla);
        }else{
            //Toast.makeText(context, "Conexion error", Toast.LENGTH_SHORT).show();
        }
        return arrayCatalogoSalsaQuesadilla;
    }


    public static ArrayList<ItemCatalogoTipoBebida> descargar_catalogobebida(Context context){
        String URL_catalogo_bebida = "https://examenmoviles.000webhostapp.com/catalogobebida.xml";
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        ArrayList<ItemCatalogoTipoBebida> arrayCatalogoBebida = null;

        if (networkInfo != null && networkInfo.isConnected()){
            //Toast.makeText(context, "Conexion ok", Toast.LENGTH_SHORT).show();
            arrayCatalogoBebida = descargar_catalogobebida_interna(URL_catalogo_bebida);
        }else{
            //Toast.makeText(context, "Conexion error", Toast.LENGTH_SHORT).show();
        }
        return arrayCatalogoBebida;
    }



    //********************************** METODOS PRIVADOS ******************************
    //TACOS
    private static ArrayList<Taco> descargar_lista_tacos_interna(String url_string){
        HttpURLConnection conn = null;
        Document doc = null;
        ArrayList <Taco> arrayTacos = null;
        try {
            URL url = new URL(url_string);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.connect();
            int responseCode = conn.getResponseCode();
            if(responseCode == HttpsURLConnection.HTTP_OK){
                doc = parseXML(conn.getInputStream());
                arrayTacos = parseDocTacos(doc.getDocumentElement());
            }else if(responseCode == HttpsURLConnection.HTTP_CONFLICT){
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (conn != null){
                conn.disconnect();
            }
        }
        return arrayTacos;
    }

    private static Document parseXML(InputStream stream) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(stream);
        return document;
    }



    private static ArrayList<Taco> parseDocTacos(Element raiz){
        ArrayList<Taco> arrayTacos = new ArrayList<Taco>();
        NodeList items = raiz.getElementsByTagName("taco");

        for(int i=0; i<items.getLength(); i++){
            Node nodeTaco = items.item(i);
            Taco taco = new Taco();
            for(int j=0; j<nodeTaco.getChildNodes().getLength(); j++){
                Node nodeActual = nodeTaco.getChildNodes().item(j);
                if(nodeActual.getNodeType() == Node.ELEMENT_NODE){
                    if(nodeActual.getNodeName().equalsIgnoreCase("carne")){
                        taco.setCarne(nodeActual.getChildNodes().item(0).getNodeValue());
                    }else if(nodeActual.getNodeName().equalsIgnoreCase("tipo_salsa")){
                        taco.setTipo_salsa(Integer.parseInt(nodeActual.getChildNodes().item(0).getNodeValue()));
                    }else if(nodeActual.getNodeName().equalsIgnoreCase("limon")){
                        taco.setLimon(Integer.parseInt(nodeActual.getChildNodes().item(0).getNodeValue()) == 1);
                    }else if(nodeActual.getNodeName().equalsIgnoreCase("cilantro")){
                        taco.setCilantro(Integer.parseInt(nodeActual.getChildNodes().item(0).getNodeValue()) == 1);
                    }else if(nodeActual.getNodeName().equalsIgnoreCase("cebolla")){
                        taco.setCebolla(Integer.parseInt(nodeActual.getChildNodes().item(0).getNodeValue()) == 1);
                    }
                }
            }
            arrayTacos.add(taco);
        }
        return arrayTacos;
    }


    //QUESADILLLAS
    private static ArrayList<Quesadilla> descargar_lista_quesadillas_interna(String url_string){
        HttpURLConnection conn = null;
        Document doc = null;
        ArrayList<Quesadilla> arrayQuesadillas = null;
        try {
            URL url = new URL(url_string);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.connect();
            int responseCode = conn.getResponseCode();
            if(responseCode == HttpsURLConnection.HTTP_OK){
                doc = parseXML(conn.getInputStream());
                arrayQuesadillas = parseDocQuesadillas(doc.getDocumentElement());
            }else if(responseCode == HttpsURLConnection.HTTP_CONFLICT){
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (conn != null){
                conn.disconnect();
            }
        }
        return arrayQuesadillas;
    }

    private static ArrayList<Quesadilla> parseDocQuesadillas(Element raiz){
        ArrayList<Quesadilla> arrayQuesadillas = new ArrayList<Quesadilla>();
        NodeList items = raiz.getElementsByTagName("quesadilla");

        for(int i=0; i<items.getLength(); i++){
            Node nodeQuesadilla = items.item(i);
            Quesadilla quesadilla = new Quesadilla();
            for(int j=0; j<nodeQuesadilla.getChildNodes().getLength(); j++){
                Node nodeActual = nodeQuesadilla.getChildNodes().item(j);
                if(nodeActual.getNodeType() == Node.ELEMENT_NODE){
                    if(nodeActual.getNodeName().equalsIgnoreCase("ingredinte")){
                        quesadilla.setIngrediente(nodeActual.getChildNodes().item(0).getNodeValue());
                    }else if(nodeActual.getNodeName().equalsIgnoreCase("tipo_salsa")){
                        quesadilla.setTipo_salsa(Integer.parseInt(nodeActual.getChildNodes().item(0).getNodeValue()));
                    }else if(nodeActual.getNodeName().equalsIgnoreCase("queso")){
                        quesadilla.setQueso(Integer.parseInt(nodeActual.getChildNodes().item(0).getNodeValue()) == 1);
                    }
                }
            }
            arrayQuesadillas.add(quesadilla);
        }
        return arrayQuesadillas;
    }



    //BEBIDAS
    private static ArrayList<Bebida> descargar_lista_bebidas_interna(String url_string){
        HttpURLConnection conn = null;
        Document doc = null;
        ArrayList<Bebida> arrayBebidas = null;
        try {
            URL url = new URL(url_string);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.connect();
            int responseCode = conn.getResponseCode();
            if(responseCode == HttpsURLConnection.HTTP_OK){
                doc = parseXML(conn.getInputStream());
                arrayBebidas = parseDocBebidas(doc.getDocumentElement());
            }else if(responseCode == HttpsURLConnection.HTTP_CONFLICT){
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (conn != null){
                conn.disconnect();
            }
        }
        return arrayBebidas;
    }

    private static ArrayList<Bebida> parseDocBebidas(Element raiz){
        ArrayList<Bebida> arrayBebidas = new ArrayList<Bebida>();
        NodeList items = raiz.getElementsByTagName("bebida");

        for(int i=0; i<items.getLength(); i++){
            Node nodeBebida = items.item(i);
            Bebida bebida = new Bebida();
            for(int j=0; j<nodeBebida.getChildNodes().getLength(); j++){
                Node nodeActual = nodeBebida.getChildNodes().item(j);
                if(nodeActual.getNodeType() == Node.ELEMENT_NODE){
                    if(nodeActual.getNodeName().equalsIgnoreCase("sabor")){
                        bebida.setSabor(nodeActual.getChildNodes().item(0).getNodeValue());
                    }else if(nodeActual.getNodeName().equalsIgnoreCase("tipo")) {
                        bebida.setTipo(Integer.parseInt(nodeActual.getChildNodes().item(0).getNodeValue()));
                    }
                }
            }
            arrayBebidas.add(bebida);
        }
        return arrayBebidas;
    }



    //CATALOGO SALSA TACO
    private static ArrayList<ItemCatalogoSalsaTaco> descargar_catalogosalsataco_interna(String url_string){
        HttpURLConnection conn = null;
        Document doc = null;
        ArrayList<ItemCatalogoSalsaTaco> arrayCatalogoSalsaTaco = null;
        try {
            URL url = new URL(url_string);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.connect();
            int responseCode = conn.getResponseCode();
            if(responseCode == HttpsURLConnection.HTTP_OK){
                doc = parseXML(conn.getInputStream());
                arrayCatalogoSalsaTaco = parseDocCatalogoSalsaTaco(doc.getDocumentElement());
            }else if(responseCode == HttpsURLConnection.HTTP_CONFLICT){
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (conn != null){
                conn.disconnect();
            }
        }
        return arrayCatalogoSalsaTaco;
    }

    private static ArrayList<ItemCatalogoSalsaTaco> parseDocCatalogoSalsaTaco(Element raiz){
        ArrayList<ItemCatalogoSalsaTaco> arrayCatalogoSalsaTaco = new ArrayList<ItemCatalogoSalsaTaco>();
        NodeList items = raiz.getElementsByTagName("salsataco");

        for(int i=0; i<items.getLength(); i++){
            Node node = items.item(i);
            ItemCatalogoSalsaTaco item_catalogo = new ItemCatalogoSalsaTaco();
            for(int j=0; j<node.getChildNodes().getLength(); j++){
                Node nodeActual = node.getChildNodes().item(j);
                if(nodeActual.getNodeType() == Node.ELEMENT_NODE){
                    if(nodeActual.getNodeName().equalsIgnoreCase("id")) {
                        item_catalogo.setId(Integer.parseInt(nodeActual.getChildNodes().item(0).getNodeValue()));
                    }else if((nodeActual.getNodeName().equalsIgnoreCase("salsa"))){
                        item_catalogo.setSalsa(nodeActual.getChildNodes().item(0).getNodeValue());
                    }
                }
            }
            arrayCatalogoSalsaTaco.add(item_catalogo);
        }
        return arrayCatalogoSalsaTaco;
    }




    //CATALOGO SALSA QUESADILLA
    private static ArrayList<ItemCatalogoSalsaQuesadilla> descargar_catalogosalsaquesadilla_interna(String url_string){
        HttpURLConnection conn = null;
        Document doc = null;
        ArrayList<ItemCatalogoSalsaQuesadilla> arrayCatalogoSalsaQuesadilla = null;
        try {
            URL url = new URL(url_string);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.connect();
            int responseCode = conn.getResponseCode();
            if(responseCode == HttpsURLConnection.HTTP_OK){
                doc = parseXML(conn.getInputStream());
                arrayCatalogoSalsaQuesadilla = parseDocCatalogoSalsaQuesadilla(doc.getDocumentElement());
            }else if(responseCode == HttpsURLConnection.HTTP_CONFLICT){
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (conn != null){
                conn.disconnect();
            }
        }
        return arrayCatalogoSalsaQuesadilla;
    }

    private static ArrayList<ItemCatalogoSalsaQuesadilla> parseDocCatalogoSalsaQuesadilla(Element raiz){
        ArrayList<ItemCatalogoSalsaQuesadilla> arrayCatalogoSalsaQuesadilla = new ArrayList<ItemCatalogoSalsaQuesadilla>();
        NodeList items = raiz.getElementsByTagName("salsaquesadilla");

        for(int i=0; i<items.getLength(); i++){
            Node node = items.item(i);
            ItemCatalogoSalsaQuesadilla item_catalogo = new ItemCatalogoSalsaQuesadilla();
            for(int j=0; j<node.getChildNodes().getLength(); j++){
                Node nodeActual = node.getChildNodes().item(j);
                if(nodeActual.getNodeType() == Node.ELEMENT_NODE){
                    if(nodeActual.getNodeName().equalsIgnoreCase("id")) {
                        item_catalogo.setId(Integer.parseInt(nodeActual.getChildNodes().item(0).getNodeValue()));
                    }else if((nodeActual.getNodeName().equalsIgnoreCase("salsa"))){
                        item_catalogo.setSalsa(nodeActual.getChildNodes().item(0).getNodeValue());
                    }
                }
            }
            arrayCatalogoSalsaQuesadilla.add(item_catalogo);
        }
        return arrayCatalogoSalsaQuesadilla;
    }


    //CATALOGO TIPO BEBIDA
    private static ArrayList<ItemCatalogoTipoBebida> descargar_catalogobebida_interna(String url_string){
        HttpURLConnection conn = null;
        Document doc = null;
        ArrayList<ItemCatalogoTipoBebida> arrayCatalogoBebida = null;
        try {
            URL url = new URL(url_string);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.connect();
            int responseCode = conn.getResponseCode();
            if(responseCode == HttpsURLConnection.HTTP_OK){
                doc = parseXML(conn.getInputStream());
                arrayCatalogoBebida = parseDocCatalogoBebida(doc.getDocumentElement());
            }else if(responseCode == HttpsURLConnection.HTTP_CONFLICT){
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (conn != null){
                conn.disconnect();
            }
        }
        return arrayCatalogoBebida;
    }

    private static ArrayList<ItemCatalogoTipoBebida> parseDocCatalogoBebida(Element raiz){
        ArrayList<ItemCatalogoTipoBebida> arrayCatalogoBebida = new ArrayList<ItemCatalogoTipoBebida>();
        NodeList items = raiz.getElementsByTagName("tipobebida");

        for(int i=0; i<items.getLength(); i++){
            Node node = items.item(i);
            ItemCatalogoTipoBebida item_catalogo = new ItemCatalogoTipoBebida();
            for(int j=0; j<node.getChildNodes().getLength(); j++){
                Node nodeActual = node.getChildNodes().item(j);
                if(nodeActual.getNodeType() == Node.ELEMENT_NODE){
                    if(nodeActual.getNodeName().equalsIgnoreCase("id")) {
                        item_catalogo.setId(Integer.parseInt(nodeActual.getChildNodes().item(0).getNodeValue()));
                    }else if((nodeActual.getNodeName().equalsIgnoreCase("tipo"))){
                        item_catalogo.setTipo(nodeActual.getChildNodes().item(0).getNodeValue());
                    }
                }
            }
            arrayCatalogoBebida.add(item_catalogo);
        }
        return arrayCatalogoBebida;
    }
}
