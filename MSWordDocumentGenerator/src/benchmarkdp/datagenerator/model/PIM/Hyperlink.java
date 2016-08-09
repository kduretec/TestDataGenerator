/**
 */
package benchmarkdp.datagenerator.model.PIM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hyperlink</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link benchmarkdp.datagenerator.model.PIM.Hyperlink#getUrl <em>Url</em>}</li>
 * </ul>
 *
 * @see benchmarkdp.datagenerator.model.PIM.PIMPackage#getHyperlink()
 * @model extendedMetaData="name='HyperLink'"
 * @generated
 */
public interface Hyperlink extends Text {
	/**
	 * Returns the value of the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Url</em>' attribute.
	 * @see #setUrl(String)
	 * @see benchmarkdp.datagenerator.model.PIM.PIMPackage#getHyperlink_Url()
	 * @model
	 * @generated
	 */
	String getUrl();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PIM.Hyperlink#getUrl <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url</em>' attribute.
	 * @see #getUrl()
	 * @generated
	 */
	void setUrl(String value);

} // Hyperlink
