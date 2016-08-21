/**
 */
package benchmarkdp.datagenerator.model.PSMDocx;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Paragraph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMDocx.Paragraph#getIndent <em>Indent</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMDocx.Paragraph#getParagraphSpacing <em>Paragraph Spacing</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMDocx.Paragraph#getLineSpacing <em>Line Spacing</em>}</li>
 * </ul>
 *
 * @see benchmarkdp.datagenerator.model.PSMDocx.PSMDocxPackage#getParagraph()
 * @model
 * @generated
 */
public interface Paragraph extends TextContainer {
	/**
	 * Returns the value of the '<em><b>Indent</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Indent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Indent</em>' attribute.
	 * @see #setIndent(double)
	 * @see benchmarkdp.datagenerator.model.PSMDocx.PSMDocxPackage#getParagraph_Indent()
	 * @model default="1.0"
	 * @generated
	 */
	double getIndent();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PSMDocx.Paragraph#getIndent <em>Indent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Indent</em>' attribute.
	 * @see #getIndent()
	 * @generated
	 */
	void setIndent(double value);

	/**
	 * Returns the value of the '<em><b>Paragraph Spacing</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Paragraph Spacing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Paragraph Spacing</em>' attribute.
	 * @see #setParagraphSpacing(double)
	 * @see benchmarkdp.datagenerator.model.PSMDocx.PSMDocxPackage#getParagraph_ParagraphSpacing()
	 * @model default="1.0"
	 * @generated
	 */
	double getParagraphSpacing();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PSMDocx.Paragraph#getParagraphSpacing <em>Paragraph Spacing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Paragraph Spacing</em>' attribute.
	 * @see #getParagraphSpacing()
	 * @generated
	 */
	void setParagraphSpacing(double value);

	/**
	 * Returns the value of the '<em><b>Line Spacing</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line Spacing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line Spacing</em>' attribute.
	 * @see #setLineSpacing(double)
	 * @see benchmarkdp.datagenerator.model.PSMDocx.PSMDocxPackage#getParagraph_LineSpacing()
	 * @model default="1.0"
	 * @generated
	 */
	double getLineSpacing();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PSMDocx.Paragraph#getLineSpacing <em>Line Spacing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Spacing</em>' attribute.
	 * @see #getLineSpacing()
	 * @generated
	 */
	void setLineSpacing(double value);

} // Paragraph
