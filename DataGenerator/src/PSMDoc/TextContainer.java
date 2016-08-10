/**
 */
package PSMDoc;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link PSMDoc.TextContainer#getWords <em>Words</em>}</li>
 * </ul>
 *
 * @see PSMDoc.PSMDocPackage#getTextContainer()
 * @model
 * @generated
 */
public interface TextContainer extends Element {
	/**
	 * Returns the value of the '<em><b>Words</b></em>' containment reference list.
	 * The list contents are of type {@link PSMDoc.Text}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Words</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Words</em>' containment reference list.
	 * @see PSMDoc.PSMDocPackage#getTextContainer_Words()
	 * @model containment="true"
	 * @generated
	 */
	EList<Text> getWords();

} // TextContainer
