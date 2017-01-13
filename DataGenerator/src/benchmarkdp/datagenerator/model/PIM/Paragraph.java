/**
 */
package benchmarkdp.datagenerator.model.PIM;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Paragraph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link benchmarkdp.datagenerator.model.PIM.Paragraph#getWords <em>Words</em>}</li>
 * </ul>
 *
 * @see benchmarkdp.datagenerator.model.PIM.PIMPackage#getParagraph()
 * @model
 * @generated
 */
public interface Paragraph extends Element {
	/**
	 * Returns the value of the '<em><b>Words</b></em>' containment reference list.
	 * The list contents are of type {@link benchmarkdp.datagenerator.model.PIM.Word}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Words</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Words</em>' containment reference list.
	 * @see benchmarkdp.datagenerator.model.PIM.PIMPackage#getParagraph_Words()
	 * @model containment="true"
	 * @generated
	 */
	EList<Word> getWords();

} // Paragraph
