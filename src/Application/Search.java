package Application;

public class Search {
	
	private String Titulo;
	private String Links ;
	private String descricaoPost;
	private String URLDownload;
	
	public Search() {
		
	}
	
	public Search(String titulo, String links, String descricaoPost, String uRLDownload) {
		super();
		this.Titulo = titulo;
		this.Links = links;
		this.descricaoPost = descricaoPost;
		this.URLDownload = uRLDownload;
	}

	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getLinks() {
		return Links;
	}
	public void setLinks(String links) {
		Links = links;
	}
	public String getDescricaoPost() {
		return descricaoPost;
	}
	public void setDescricaoPost(String descricaoPost) {
		this.descricaoPost = descricaoPost;
	}
	public String getURLDownload() {
		return URLDownload;
	}
	public void setURLDownload(String uRLDownload) {
		URLDownload = uRLDownload;
	}
	@Override
	public String toString() {
		return "Busca [Titulo=" + Titulo + ", Links=" + Links + ", descricaoPost=" + descricaoPost + ", URLDownload="
				+ URLDownload + "]";
	}
	
}
