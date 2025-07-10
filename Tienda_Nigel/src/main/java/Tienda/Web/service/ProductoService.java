/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Tienda.Web.service;
import Tienda.Web.domain.Producto;
import java.util.List;
/**
 *
 * @author nigel
 */


public interface ProductoService {

    // Se obtiene un listado de productos en un List
    public List<Producto> getProductos(boolean activos);

    // Se obtiene un Producto, a partir del id de un producto
    public Producto getProducto(Producto producto);

    // Se inserta un nuevo producto si el id del producto está vacío
    // Se actualiza un producto si el id del producto NO está vacío
    public void save(Producto producto);

    // Se elimina el producto que tiene el id pasado por parámetro
    public void delete(Producto producto);

    // Lista de productos con precio entre ordenados por descripción ConsultaAmpliada
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);

    // Lista de productos utilizando consultas con JPQL
    public List<Producto> metodoJPQL(double precioInf, double precioSup);
   

    // Lista de productos utilizando consultas con SQL Nativo
    public List<Producto> metodoNativo(double precioInf, double precioSup);
}