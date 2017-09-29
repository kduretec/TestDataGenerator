/**
 */
package benchmarkdp.datagenerator.model.PIM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link benchmarkdp.datagenerator.model.PIM.TextContainer#getFontColor <em>Font Color</em>}</li>
 * </ul>
 *
 * @see benchmarkdp.datagenerator.model.PIM.PIMPackage#getTextContainer()
 * @model abstract="true"
 * @generated
 */
public interface TextContainer extends Element {
	/**
	 * Returns the value of the '<em><b>Font Color</b></em>' attribute.
	 * The default value is <code>"BLACK"</code>.
	 * The literals are from the enumeration {@link benchmarkdp.datagenerator.model.PIM.Color}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font Color</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Color</em>' attribute.
	 * @see benchmarkdp.datagenerator.model.PIM.Color
	 * @see #setFontColor(Color)
	 * @see benchmarkdp.datagenerator.model.PIM.PIMPackage#getTextContainer_FontColor()
	 * @model default="BLACK"
	 * @generated
	 */
	Color getFontColor();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PIM.TextContainer#getFontColor <em>Font Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Color</em>' attribute.
	 * @see benchmarkdp.datagenerator.model.PIM.Color
	 * @see #getFontColor()
	 * @generated
	 */
	void setFontColor(Color value);

} // TextContainer
