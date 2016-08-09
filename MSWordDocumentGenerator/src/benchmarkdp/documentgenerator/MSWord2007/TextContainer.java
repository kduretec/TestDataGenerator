/**
 */
package benchmarkdp.documentgenerator.MSWord2007;

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
 *   <li>{@link benchmarkdp.documentgenerator.MSWord2007.TextContainer#getWords <em>Words</em>}</li>
 * </ul>
 *
 * @see benchmarkdp.documentgenerator.MSWord2007.MSWordPackage#getTextContainer()
 * @model
 * @generated
 */
public interface TextContainer extends Element {
	/**
	 * Returns the value of the '<em><b>Words</b></em>' containment reference list.
	 * The list contents are of type {@link benchmarkdp.documentgenerator.MSWord2007.Text}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Words</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Words</em>' containment reference list.
	 * @see benchmarkdp.documentgenerator.MSWord2007.MSWordPackage#getTextContainer_Words()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Text> getWords();

} // TextContainer
