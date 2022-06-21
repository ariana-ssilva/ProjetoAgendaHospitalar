package br.com.entra21.model2022.main.enter.registration.menu.crud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public interface ICrud<M> {
	
	ArrayList<String> option = new ArrayList<String>(
			Arrays.asList("List", "Add", "Search", "Edit", "Delete"));

	public void list(HashMap<String, M> list);

	public void add();

	public M search(M key);

	public void edit(M key);

	public void delete(M key);

	public M captureKey();

	public M captureValue();

	public void showDetails(M complete);
}
