/**
 */
package benchmarkdp.datagenerator.model.PSMDocx;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Text</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMDocx.SimpleText#getFontFamily <em>Font Family</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMDocx.SimpleText#getSize <em>Size</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMDocx.SimpleText#getColor <em>Color</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMDocx.SimpleText#getBackground <em>Background</em>}</li>
 * </ul>
 *
 * @see benchmarkdp.datagenerator.model.PSMDocx.PSMDocxPackage#getSimpleText()
 * @model
 * @generated
 */
public interface SimpleText extends Text {
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
	 * @see benchmarkdp.datagenerator.model.PSMDocx.PSMDocxPackage#getSimpleText_FontFamily()
	 * @model
	 * @generated
	 */
	FontFamily getFontFamily();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PSMDocx.SimpleText#getFontFamily <em>Font Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Family</em>' attribute.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.FontFamily
	 * @see #getFontFamily()
	 * @generated
	 */
	void setFontFamily(FontFamily value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * The default value is <code>"10"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(int)
	 * @see benchmarkdp.datagenerator.model.PSMDocx.PSMDocxPackage#getSimpleText_Size()
	 * @model default="10"
	 * @generated
	 */
	int getSize();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PSMDocx.SimpleText#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(int value);

	/**
	 * Returns the value of the '<em><b>Color</b></em>' attribute.
	 * The literals are from the enumeration {@link benchmarkdp.datagenerator.model.PSMDocx.Color}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Color</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color</em>' attribute.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Color
	 * @see #setColor(Color)
	 * @see benchmarkdp.datagenerator.model.PSMDocx.PSMDocxPackage#getSimpleText_Color()
	 * @model
	 * @generated
	 */
	Color getColor();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PSMDocx.SimpleText#getColor <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color</em>' attribute.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Color
	 * @see #getColor()
	 * @generated
	 */
	void setColor(Color value);

	/**
	 * Returns the value of the '<em><b>Background</b></em>' attribute.
	 * The default value is <code>"WHITE"</code>.
	 * The literals are from the enumeration {@link benchmarkdp.datagenerator.model.PSMDocx.Color}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Background</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Background</em>' attribute.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Color
	 * @see #setBackground(Color)
	 * @see benchmarkdp.datagenerator.model.PSMDocx.PSMDocxPackage#getSimpleText_Background()
	 * @model default="WHITE"
	 * @generated
	 */
	Color getBackground();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PSMDocx.SimpleText#getBackground <em>Background</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Background</em>' attribute.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Color
	 * @see #getBackground()
	 * @generated
	 */
	void setBackground(Color value);

} // SimpleText
