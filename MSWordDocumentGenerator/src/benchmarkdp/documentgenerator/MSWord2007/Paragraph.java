/**
 */
package benchmarkdp.documentgenerator.MSWord2007;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Paragraph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link benchmarkdp.documentgenerator.MSWord2007.Paragraph#getParagraphSpacing <em>Paragraph Spacing</em>}</li>
 *   <li>{@link benchmarkdp.documentgenerator.MSWord2007.Paragraph#getLineSpacing <em>Line Spacing</em>}</li>
 *   <li>{@link benchmarkdp.documentgenerator.MSWord2007.Paragraph#getIndent <em>Indent</em>}</li>
 * </ul>
 *
 * @see benchmarkdp.documentgenerator.MSWord2007.MSWordPackage#getParagraph()
 * @model
 * @generated
 */
public interface Paragraph extends TextContainer {
	/**
	 * Returns the value of the '<em><b>Paragraph Spacing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Paragraph Spacing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Paragraph Spacing</em>' attribute.
	 * @see #setParagraphSpacing(double)
	 * @see benchmarkdp.documentgenerator.MSWord2007.MSWordPackage#getParagraph_ParagraphSpacing()
	 * @model
	 * @generated
	 */
	double getParagraphSpacing();

	/**
	 * Sets the value of the '{@link benchmarkdp.documentgenerator.MSWord2007.Paragraph#getParagraphSpacing <em>Paragraph Spacing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Paragraph Spacing</em>' attribute.
	 * @see #getParagraphSpacing()
	 * @generated
	 */
	void setParagraphSpacing(double value);

	/**
	 * Returns the value of the '<em><b>Line Spacing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line Spacing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line Spacing</em>' attribute.
	 * @see #setLineSpacing(double)
	 * @see benchmarkdp.documentgenerator.MSWord2007.MSWordPackage#getParagraph_LineSpacing()
	 * @model
	 * @generated
	 */
	double getLineSpacing();

	/**
	 * Sets the value of the '{@link benchmarkdp.documentgenerator.MSWord2007.Paragraph#getLineSpacing <em>Line Spacing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Spacing</em>' attribute.
	 * @see #getLineSpacing()
	 * @generated
	 */
	void setLineSpacing(double value);

	/**
	 * Returns the value of the '<em><b>Indent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Indent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Indent</em>' attribute.
	 * @see #setIndent(double)
	 * @see benchmarkdp.documentgenerator.MSWord2007.MSWordPackage#getParagraph_Indent()
	 * @model
	 * @generated
	 */
	double getIndent();

	/**
	 * Sets the value of the '{@link benchmarkdp.documentgenerator.MSWord2007.Paragraph#getIndent <em>Indent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Indent</em>' attribute.
	 * @see #getIndent()
	 * @generated
	 */
	void setIndent(double value);

} // Paragraph
