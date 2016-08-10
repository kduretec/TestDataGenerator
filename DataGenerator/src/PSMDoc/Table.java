/**
 */
package PSMDoc;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link PSMDoc.Table#getRow <em>Row</em>}</li>
 * </ul>
 *
 * @see PSMDoc.PSMDocPackage#getTable()
 * @model
 * @generated
 */
public interface Table extends Element {
	/**
	 * Returns the value of the '<em><b>Row</b></em>' containment reference list.
	 * The list contents are of type {@link PSMDoc.Row}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Row</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Row</em>' containment reference list.
	 * @see PSMDoc.PSMDocPackage#getTable_Row()
	 * @model containment="true"
	 * @generated
	 */
	EList<Row> getRow();

} // Table
