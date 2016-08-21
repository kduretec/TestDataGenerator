/**
 */
package benchmarkdp.datagenerator.model.PSMDocx;

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
 *   <li>{@link benchmarkdp.datagenerator.model.PSMDocx.Table#getRow <em>Row</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMDocx.Table#getNumRows <em>Num Rows</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMDocx.Table#getNumCol <em>Num Col</em>}</li>
 * </ul>
 *
 * @see benchmarkdp.datagenerator.model.PSMDocx.PSMDocxPackage#getTable()
 * @model
 * @generated
 */
public interface Table extends Element {
	/**
	 * Returns the value of the '<em><b>Row</b></em>' containment reference list.
	 * The list contents are of type {@link benchmarkdp.datagenerator.model.PSMDocx.Row}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Row</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Row</em>' containment reference list.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.PSMDocxPackage#getTable_Row()
	 * @model containment="true"
	 * @generated
	 */
	EList<Row> getRow();

	/**
	 * Returns the value of the '<em><b>Num Rows</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Num Rows</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Rows</em>' attribute.
	 * @see #setNumRows(int)
	 * @see benchmarkdp.datagenerator.model.PSMDocx.PSMDocxPackage#getTable_NumRows()
	 * @model
	 * @generated
	 */
	int getNumRows();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PSMDocx.Table#getNumRows <em>Num Rows</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Rows</em>' attribute.
	 * @see #getNumRows()
	 * @generated
	 */
	void setNumRows(int value);

	/**
	 * Returns the value of the '<em><b>Num Col</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Num Col</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Col</em>' attribute.
	 * @see #setNumCol(int)
	 * @see benchmarkdp.datagenerator.model.PSMDocx.PSMDocxPackage#getTable_NumCol()
	 * @model
	 * @generated
	 */
	int getNumCol();

	/**
	 * Sets the value of the '{@link benchmarkdp.datagenerator.model.PSMDocx.Table#getNumCol <em>Num Col</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Col</em>' attribute.
	 * @see #getNumCol()
	 * @generated
	 */
	void setNumCol(int value);

} // Table
