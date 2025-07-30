/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Tienda.Web.service;
import jakarta.mail.MessagingException;
/**
 *
 * @author nigel
 */
//creacion del servicio de correos con las caracteristicas de para quien el asunto el contenido y si llega a ocurrir un error lanza una excepcion 
public interface CorreoService {
    public void enviarCorreoHtml(
            String para, 
            String asunto, 
            String contenidoHtml) 
            throws MessagingException;
}

