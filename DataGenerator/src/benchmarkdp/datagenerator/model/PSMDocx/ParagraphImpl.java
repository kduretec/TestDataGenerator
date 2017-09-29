/**
 */
package benchmarkdp.datagenerator.model.PSMDocx;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Paragraph Impl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMDocx.ParagraphImpl#getText <em>Text</em>}</li>
 * </ul>
 *
 * @see benchmarkdp.datagenerator.model.PSMDocx.PSMDocxPackage#getParagraphImpl()
 * @model abstract="true"
 * @generated
 */
public interface ParagraphImpl extends TextContainer {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' containment reference list.
	 * The list contents are of type {@link benchmarkdp.datagenerator.model.PSMDocx.Text}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' containment reference list.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.PSMDocxPackage#getParagraphImpl_Text()
	 * @model containment="true"
	 * @generated
	 */
	EList<Text> getText();

} // ParagraphImpl
