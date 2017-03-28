package xshop.core;

import xshop.entity.Supplier;
import xshop.data.SupplierRepository;
import java.util.List;

public class SupplierService{
	SupplierRepository repository;
	
	public SupplierService(){
		repository = new SupplierRepository();
	}
	
    public boolean add(Supplier supplier){
        return repository.add(supplier);
    }

    public boolean edit(Supplier supplier){
        return repository.edit(supplier);
    }

    public Supplier getById(int supplierId){
        return repository.getById(supplierId);
    }

    public List<Supplier> getAll(){
        return repository.getAll();
    }

    public boolean remove(int supplierId){
        return repository.remove(supplierId);
    }
}