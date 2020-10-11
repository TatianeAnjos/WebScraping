package Application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import db.DB;

public class Main {

	private static List<String> titulos = new ArrayList<>();
	private static List<String> links = new ArrayList<>();
	private static List<String> descricao = new ArrayList<>();
	private static List<String> URLDownload = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		execute();
	}

	public static void execute() {

		SearchJDBC jdbc = new SearchJDBC(DB.getConnection());
		System.out.println("Scraping iniciado..\n");
	
		int no_pagina = 1;
		while (no_pagina <= 393) {

			System.out.println("\nBuscando dados da página "+ no_pagina+"...\n");
			titulos = Scrap.buscarTitulo(no_pagina);
			links = Scrap.buscarLink(no_pagina);
			descricao = Scrap.buscarDescricao(no_pagina);
			URLDownload = Scrap.buscarURLDownload(no_pagina);
			no_pagina++;

			//  número de registros por pagina = 10
			int count = 0;
			for (int i = 0; i <= 9; i++) {

				String t = titulos.get(count);
				String l = links.get(count);
				String d = descricao.get(count);
				String u = URLDownload.get(count);

				Search busca = new Search(t, l, d, u);
				jdbc.Insert(busca);
				busca.toString();
				count++;

			}
		}
		System.out.println("Dados inseridos no banco!\n");
		System.out.println("Busca finalizada.");
	}
}
