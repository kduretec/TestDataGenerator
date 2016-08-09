/**
 */
package benchmarkdp.documentgenerator.MSWord2007;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Page</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link benchmarkdp.documentgenerator.MSWord2007.Page#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see benchmarkdp.documentgenerator.MSWord2007.MSWordPackage#getPage()
 * @model
 * @generated
 */
public interface Page extends EObject {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link benchmarkdp.documentgenerator.MSWord2007.Element}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see benchmarkdp.documentgenerator.MSWord2007.MSWordPackage#getPage_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Element> getElements();

} // Page
