/**
 */
package benchmarkdp.datagenerator.model.PSMDoc;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Row</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMDoc.Row#getCell <em>Cell</em>}</li>
 * </ul>
 *
 * @see benchmarkdp.datagenerator.model.PSMDoc.PSMDocPackage#getRow()
 * @model
 * @generated
 */
public interface Row extends EObject {
	/**
	 * Returns the value of the '<em><b>Cell</b></em>' containment reference list.
	 * The list contents are of type {@link benchmarkdp.datagenerator.model.PSMDoc.Cell}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cell</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cell</em>' containment reference list.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.PSMDocPackage#getRow_Cell()
	 * @model containment="true"
	 * @generated
	 */
	EList<Cell> getCell();

} // Row
