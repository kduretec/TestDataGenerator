/**
 */
package benchmarkdp.datagenerator.model.PSMLibre;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Text</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.SimpleText#getFontFamily <em>Font Family</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.SimpleText#getFontColor <em>Font Color</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.SimpleText#getFontBackground <em>Font Background</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.SimpleText#getFontSize <em>Font Size</em>}</li>
 * </ul>
 *
 * @see benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage#getSimpleText()
 * @model
 * @generated
 */
public interface SimpleText extends Text {

	/**
	 * Returns the value of the '<em><b>Font Family</b></em>' attribute.
	 * The literals are from the enumeration {@link benchmarkdp.datagenerator.model.PSMLibre.FontFamily}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font Family</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Family</em>' attribute.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.FontFamily
	 * @see #setFontFamily(FontFamily)
	 * @see benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage#getSimpleText_FontFamily()
	 * @model
	 * @generated
	 */
	FontFamily getFontFamily();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PSMLibre.SimpleText#getFontFamily <em>Font Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Family</em>' attribute.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.FontFamily
	 * @see #getFontFamily()
	 * @generated
	 */
	void setFontFamily(FontFamily value);

	/**
	 * Returns the value of the '<em><b>Font Color</b></em>' attribute.
	 * The literals are from the enumeration {@link benchmarkdp.datagenerator.model.PSMLibre.Color}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font Color</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Color</em>' attribute.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Color
	 * @see #setFontColor(Color)
	 * @see benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage#getSimpleText_FontColor()
	 * @model
	 * @generated
	 */
	Color getFontColor();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PSMLibre.SimpleText#getFontColor <em>Font Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Color</em>' attribute.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Color
	 * @see #getFontColor()
	 * @generated
	 */
	void setFontColor(Color value);

	/**
	 * Returns the value of the '<em><b>Font Background</b></em>' attribute.
	 * The default value is <code>"WHITE"</code>.
	 * The literals are from the enumeration {@link benchmarkdp.datagenerator.model.PSMLibre.Color}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font Background</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Background</em>' attribute.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Color
	 * @see #setFontBackground(Color)
	 * @see benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage#getSimpleText_FontBackground()
	 * @model default="WHITE"
	 * @generated
	 */
	Color getFontBackground();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PSMLibre.SimpleText#getFontBackground <em>Font Background</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Background</em>' attribute.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Color
	 * @see #getFontBackground()
	 * @generated
	 */
	void setFontBackground(Color value);

	/**
	 * Returns the value of the '<em><b>Font Size</b></em>' attribute.
	 * The default value is <code>"10"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Size</em>' attribute.
	 * @see #setFontSize(int)
	 * @see benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage#getSimpleText_FontSize()
	 * @model default="10"
	 * @generated
	 */
	int getFontSize();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PSMLibre.SimpleText#getFontSize <em>Font Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Size</em>' attribute.
	 * @see #getFontSize()
	 * @generated
	 */
	void setFontSize(int value);
} // SimpleText
