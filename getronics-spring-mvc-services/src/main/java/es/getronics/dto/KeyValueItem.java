/**
 * @file KeyValueItem.java
 * @date 19 nov. 2020
 * @time 12:46:39
 * 
 */
package es.getronics.dto;

/**
 * @author alatorre
 *
 * 
 */
public class KeyValueItem {
	
	private Object key;
	private Object value;
	
	
	
	public KeyValueItem() {
		super();
	}

	public KeyValueItem(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	//getters and setters
	
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
