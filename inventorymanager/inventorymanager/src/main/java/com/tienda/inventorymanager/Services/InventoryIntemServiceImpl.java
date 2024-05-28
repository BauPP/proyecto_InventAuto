package com.tienda.inventorymanager.Services;

import java.util.List;
import java.util.Optional;

import com.tienda.inventorymanager.interfaces.IntInventario;
import com.tienda.inventorymanager.models.InventoryItem;
import com.tienda.inventorymanager.repositories.InventoryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Anotación para indicar que esta clase es un componente de servicio de Spring
public class InventoryIntemServiceImpl implements InventoryItemService {
	
	@Autowired // Inyección de dependencia del repositorio IntInventario
	private IntInventario data;

	@Override
	public List<InventoryItem> listar() {
		// Devuelve una lista de todos los elementos del inventario
		return (List<InventoryItem>)data.findAll();
	}

	@Override
	public InventoryItem listarId(int id) {
		// Método no implementado
		return null;
	}

	@Override
	public int save(InventoryItem p) {
		// Método no implementado
		return 0;
	}

	@Override
	public void delete(Long id) {
		data.deleteById(id); // Elimina un elemento del inventario por su ID
	}
}
