/**
 */
package benchmarkdp.documentgenerator.MSWord2007;

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
 *   <li>{@link benchmarkdp.documentgenerator.MSWord2007.Table#getNumRows <em>Num Rows</em>}</li>
 *   <li>{@link benchmarkdp.documentgenerator.MSWord2007.Table#getNumCol <em>Num Col</em>}</li>
 *   <li>{@link benchmarkdp.documentgenerator.MSWord2007.Table#getRow <em>Row</em>}</li>
 * </ul>
 *
 * @see benchmarkdp.documentgenerator.MSWord2007.MSWordPackage#getTable()
 * @model
 * @generated
 */
public interface Table extends Element {
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
	 * @see benchmarkdp.documentgenerator.MSWord2007.MSWordPackage#getTable_NumRows()
	 * @model
	 * @generated
	 */
	int getNumRows();

	/**
	 * Sets the value of the '{@link benchmarkdp.documentgenerator.MSWord2007.Table#getNumRows <em>Num Rows</em>}' attribute.
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
	 * @see benchmarkdp.documentgenerator.MSWord2007.MSWordPackage#getTable_NumCol()
	 * @model
	 * @generated
	 */
	int getNumCol();

	/**
	 * Sets the value of the '{@link benchmarkdp.documentgenerator.MSWord2007.Table#getNumCol <em>Num Col</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Col</em>' attribute.
	 * @see #getNumCol()
	 * @generated
	 */
	void setNumCol(int value);

	/**
	 * Returns the value of the '<em><b>Row</b></em>' containment reference list.
	 * The list contents are of type {@link benchmarkdp.documentgenerator.MSWord2007.Row}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Row</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Row</em>' containment reference list.
	 * @see benchmarkdp.documentgenerator.MSWord2007.MSWordPackage#getTable_Row()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Row> getRow();

} // Table
