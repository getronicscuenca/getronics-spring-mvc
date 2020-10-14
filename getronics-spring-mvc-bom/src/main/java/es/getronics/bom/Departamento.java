package es.getronics.bom;

import java.io.Serializable;

import javax.persistence.*;
	@Entity
	@Table(name = "DEPARTAMENTO")
	public class Departamento implements Serializable {

	
		/**
		 * 
		 */
		private static final long serialVersionUID = -9054047698877645200L;
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		@Column(name = "NOMBRE_DEPARTAMENTO")
		private String nombre;
		@Column(name="DESCRIPCION")
		private String descripcion;
		@Column(name="FECHA")
		private String fecha;

		
		/**
		 * @return the id
		 */
		public Long getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(Long id) {
			this.id = id;
		}
		/**
		 * @return the nombre
		 */
		public String getNombre() {
			return nombre;
		}
		/**
		 * @param nombre the nombre to set
		 */
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public String getFecha() {
			return fecha;
		}
		public void setFecha(String fecha) {
			this.fecha = fecha;
		}
		/**
		 * 
		 */
		
		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
			return result;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Departamento other = (Departamento) obj;
			
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (nombre == null) {
				if (other.nombre != null)
					return false;
			} else if (!nombre.equals(other.nombre))
				return false;
			return true;
		}
	}

