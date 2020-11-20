/**
 * 
 */
package es.getronics.dto;

/**
 * Representa un item clave valor
 * 
 * @author jgarcia7
 *
 */
public class KeyValueItem {

	private Object key;
	private Object value;
	public Object getKey() {
		return key;
	}
	public void setKey(Object key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}	
}
