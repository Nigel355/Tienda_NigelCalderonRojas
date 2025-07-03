/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Tienda.Web.dao;

import Tienda.Web.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author nigel
 */
public interface ProductoDao extends JpaRepository <Producto, Long> {
    
}
