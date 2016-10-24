/**
 */
package benchmarkdp.datagenerator.model.PSMLibre;

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
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.TextContainer#getWords <em>Words</em>}</li>
 * </ul>
 *
 * @see benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage#getTextContainer()
 * @model
 * @generated
 */
public interface TextContainer extends Element {
	/**
	 * Returns the value of the '<em><b>Words</b></em>' reference list.
	 * The list contents are of type {@link benchmarkdp.datagenerator.model.PSMLibre.Text}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Words</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Words</em>' reference list.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage#getTextContainer_Words()
	 * @model
	 * @generated
	 */
	EList<Text> getWords();

} // TextContainer
