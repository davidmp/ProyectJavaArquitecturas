/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.api.global;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.syscenterlife.modelo.GloCategoriaProducto;
import pe.com.syscenterlife.servicio.global.CategoriaProductoServicioI;

/**
 *
 * @author davidmp
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CategoriaPrductoRControl {
    
    @Autowired
    CategoriaProductoServicioI categoriaServicioI;

	@GetMapping("/catPro")
	public List<GloCategoriaProducto> getAllCategoriaProduct() {
		System.out.println("Get all Categoria Producto...");
		List<GloCategoriaProducto> catProduct = new ArrayList<>();
		categoriaServicioI.listarEntidad().forEach(catProduct::add);

		return catProduct;
	}

	@PostMapping(value = "/catPro/create")
	public GloCategoriaProducto postCategoriaProduct(@RequestBody GloCategoriaProducto catProduct) {
		categoriaServicioI.guardarEntidad(catProduct);
		return catProduct;
	}

	@DeleteMapping("/catPro/{id}")
	public ResponseEntity<String> deleteCategoriaProduct(@PathVariable("id") int id) {
		System.out.println("Delete Categoria Producto with ID = " + id + "...");
		categoriaServicioI.eliminarEntidad(id);
		return new ResponseEntity<>("Categoria Producto has been deleted!", HttpStatus.OK);
	}



	@GetMapping(value = "/catPro/dato/{nombre}")
	public List<GloCategoriaProducto> findEntidadDato(@PathVariable String nombre) {

		List<GloCategoriaProducto> catProduct = categoriaServicioI.listarEntidadDato(nombre);
		return catProduct;
	}

	@PutMapping("/catPro/{id}")
	public ResponseEntity<String> updateCategoriaProduct(@PathVariable("id") int id, @RequestBody GloCategoriaProducto catProduct) {
		System.out.println("Update Categoria Producto with ID = " + id + "...");
                
                try {
                    categoriaServicioI.guardarEntidad(catProduct);
                return new ResponseEntity<>("Se Actualizo Correctamente", HttpStatus.OK);
                } catch (Exception e) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
	}    
}
