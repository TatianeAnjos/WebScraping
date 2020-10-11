package Application;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scrap {

	public static List<String> buscarTitulo(int no_pagina) {
		List<String> titulos = new ArrayList<>();
		Document doc = null;
		String linkAtual = formatLink(no_pagina);
		try {
			doc = Jsoup.connect(linkAtual).get();
		} catch (Exception e) {
			System.out.println("Site indisponível ou falha na requisição");
		}
		Elements titulo = doc.select("h2.entry-title").select("a");
		String[] conteudo = new String[9];

		for (Element t : titulo) {
			String a = t.text();
			conteudo = a.split("\n");
			for (String line : conteudo) {
				titulos.add(line);
			}
		}
		return titulos;
	}

	public static List<String> buscarLink(int no_pagina) {
		List<String> links = new ArrayList<>();
		Document doc = null;
		String linkAtual = formatLink(no_pagina);
		try {
			doc = Jsoup.connect(linkAtual).get();
		} catch (Exception e) {
			System.out.println("Site indisponível ou falha na requisição");
		}

		Elements link = doc.select("h2.entry-title").select("a[href]");
		String[] conteudo = new String[9];

		for (Element t : link) {
			String a = t.attr("href");
			conteudo = a.split("\n");
			for (String line : conteudo) {
				links.add(line);
			}
		}
		return links;
	}

	public static List<String>buscarDescricao(int no_pagina) {
		
		List<String> descricoes = new ArrayList<>();

		Document doc = null;
		String linkAtual = formatLink(no_pagina);

		try {
			doc = Jsoup.connect(linkAtual).get();
		} catch (Exception e) {
			System.out.println("Site indisponível ou falha na requisição");
		}
		Elements descricao = doc.select("div.entry-excerpt").select("p");
		String[] conteudo = new String[9];

		for (Element t : descricao) {
			String a = t.text();
			conteudo = a.split("\n");
			for (String line : conteudo) {
				descricoes.add(line);
			}
		}
		return descricoes;
	}

	public static List<String> buscarURLDownload(int no_pagina) {

		List<String> URLsDownloads = new ArrayList<>();
		
		Document doc = null;
		String linkAtual = formatLink(no_pagina);

		formatLink(no_pagina);
		try {
			doc = Jsoup.connect(linkAtual).get();
		} catch (Exception e) {
			System.out.println("Site indisponível ou falha na requisição");
		}
		doc = null;
		try {
			doc = Jsoup.connect("https://baixarmusica.me/").get();
			Elements url = doc.select("a[href].continue-reading");
			for (Element u : url) {
				String linknovo = u.attr("abs:href");
				Document doc1 = Jsoup.connect(linknovo).get();
				Elements testURL = doc1.select("tbody").select("tr").select("td").select("span").select("a[href]");
				
				String[] conteudo = new String[9];

				for (Element t : testURL) {
					String a = t.attr("href");
					conteudo = a.split("\n");
					for (String line : conteudo) {
						URLsDownloads.add(line);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Site indisponível ou falha na requisição");
		}
		return URLsDownloads;
	}

	private static String formatLink(int pagina) {
		String link = "https://baixarmusica.me/page/";
		return link + pagina;
	}
}