package br.com.locadora;

import java.util.List;

import br.com.locadora.data.AtorData;
import br.com.locadora.model.Ator;

public class Testes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			AtorData atorData = new AtorData();
			List<Ator> ators = atorData.listarTodos();

			for (Ator ator : ators) {
				System.out.println("id :" + ator.getId() + " name  : "
						+ ator.getNome());

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
