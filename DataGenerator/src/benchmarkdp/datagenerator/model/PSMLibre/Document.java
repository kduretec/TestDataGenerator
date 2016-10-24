/**
 */
package benchmarkdp.datagenerator.model.PSMLibre;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.Document#getPages <em>Pages</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMLibre.Document#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage#getDocument()
 * @model
 * @generated
 */
public interface Document extends EObject {
	/**
	 * Returns the value of the '<em><b>Pages</b></em>' reference list.
	 * The list contents are of type {@link benchmarkdp.datagenerator.model.PSMLibre.Page}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pages</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pages</em>' reference list.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage#getDocument_Pages()
	 * @model
	 * @generated
	 */
	EList<Page> getPages();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage#getDocument_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PSMLibre.Document#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Document
