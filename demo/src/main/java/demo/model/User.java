package demo.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "usu_nombre")
    private String usu_nombre;
	@Column(name = "usu_clave")
    private String usu_clave;
	@Column(name = "usu_email")
    private String usu_email;
	@Column(name = "foto_perfil")
    private String usu_foto;
    @Column(name = "nsfw_allow")
    private boolean nsfw_allow;
    @Column(name = "dark_mode")
    private boolean dark_mode;
    @Column(name = "fecha_alta")
    private LocalDateTime fecha_alta;
    @Column(name = "fecha_baja")
    private LocalDateTime fecha_baja;
   
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsu_nombre() {
		return usu_nombre;
	}
	public void setUsu_nombre(String usu_nombre) {
		this.usu_nombre = usu_nombre;
	}
	public String getUsu_clave() {
		return usu_clave;
	}
	public void setUsu_clave(String usu_clave) {
		this.usu_clave = usu_clave;
	}
	 public String getUsu_email() {
		return usu_email;
	}
	public void setUsu_email(String usu_email) {
		this.usu_email = usu_email;
	}
	public String getFoto_perfil() {
		return usu_foto;
	}
	public void setFoto_perfil(String usu_foto) {
		this.usu_foto = usu_foto;
	}
	public String getUsu_foto() {
		return usu_foto;
	}
	public void setUsu_foto(String usu_foto) {
		this.usu_foto = usu_foto;
	}
	public boolean getNsfw_allow() {
		return nsfw_allow;
	}
	public void setNsfw_allow(boolean nsfw_allow) {
		this.nsfw_allow = nsfw_allow;
	}
	public boolean getDark_mode() {
		return dark_mode;
	}
	public void setDark_mode(boolean dark_mode) {
		this.dark_mode = dark_mode;
	}
	public LocalDateTime getFecha_alta() {
		return fecha_alta;
	}
	public void setFecha_alta(LocalDateTime fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	public LocalDateTime getFecha_baja() {
		return fecha_baja;
	}
	public void setFecha_baja(LocalDateTime fecha_baja) {
		this.fecha_baja = fecha_baja;
	}



}