/**
 */
package benchmarkdp.datagenerator.model.PSMDocx;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMDocx.TextContainer#getFontColor <em>Font Color</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMDocx.TextContainer#getFontFamily <em>Font Family</em>}</li>
 * </ul>
 *
 * @see benchmarkdp.datagenerator.model.PSMDocx.PSMDocxPackage#getTextContainer()
 * @model abstract="true"
 * @generated
 */
public interface TextContainer extends Element {
	/**
	 * Returns the value of the '<em><b>Font Color</b></em>' attribute.
	 * The literals are from the enumeration {@link benchmarkdp.datagenerator.model.PSMDocx.Color}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font Color</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Color</em>' attribute.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Color
	 * @see #setFontColor(Color)
	 * @see benchmarkdp.datagenerator.model.PSMDocx.PSMDocxPackage#getTextContainer_FontColor()
	 * @model
	 * @generated
	 */
	Color getFontColor();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PSMDocx.TextContainer#getFontColor <em>Font Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Color</em>' attribute.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Color
	 * @see #getFontColor()
	 * @generated
	 */
	void setFontColor(Color value);

	/**
	 * Returns the value of the '<em><b>Font Family</b></em>' attribute.
	 * The literals are from the enumeration {@link benchmarkdp.datagenerator.model.PSMDocx.FontFamily}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font Family</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Family</em>' attribute.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.FontFamily
	 * @see #setFontFamily(FontFamily)
	 * @see benchmarkdp.datagenerator.model.PSMDocx.PSMDocxPackage#getTextContainer_FontFamily()
	 * @model
	 * @generated
	 */
	FontFamily getFontFamily();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PSMDocx.TextContainer#getFontFamily <em>Font Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Family</em>' attribute.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.FontFamily
	 * @see #getFontFamily()
	 * @generated
	 */
	void setFontFamily(FontFamily value);

} // TextContainer
