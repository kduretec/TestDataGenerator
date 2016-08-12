/**
 */
package benchmarkdp.datagenerator.model.PSMDoc.impl;

import benchmarkdp.datagenerator.model.PSMDoc.PSMDocPackage;
import benchmarkdp.datagenerator.model.PSMDoc.Row;
import benchmarkdp.datagenerator.model.PSMDoc.Table;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMDoc.impl.TableImpl#getRow <em>Row</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMDoc.impl.TableImpl#getNumRows <em>Num Rows</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMDoc.impl.TableImpl#getNumCol <em>Num Col</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TableImpl extends ElementImpl implements Table {
	/**
	 * The cached value of the '{@link #getRow() <em>Row</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRow()
	 * @generated
	 * @ordered
	 */
	protected EList<Row> row;

	/**
	 * The default value of the '{@link #getNumRows() <em>Num Rows</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumRows()
	 * @generated
	 * @ordered
	 */
	protected static final int NUM_ROWS_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getNumRows() <em>Num Rows</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumRows()
	 * @generated
	 * @ordered
	 */
	protected int numRows = NUM_ROWS_EDEFAULT;
	/**
	 * The default value of the '{@link #getNumCol() <em>Num Col</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumCol()
	 * @generated
	 * @ordered
	 */
	protected static final int NUM_COL_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getNumCol() <em>Num Col</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumCol()
	 * @generated
	 * @ordered
	 */
	protected int numCol = NUM_COL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PSMDocPackage.Literals.TABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Row> getRow() {
		if (row == null) {
			row = new EObjectContainmentEList<Row>(Row.class, this, PSMDocPackage.TABLE__ROW);
		}
		return row;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumRows() {
		return numRows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumRows(int newNumRows) {
		int oldNumRows = numRows;
		numRows = newNumRows;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PSMDocPackage.TABLE__NUM_ROWS, oldNumRows, numRows));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumCol() {
		return numCol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumCol(int newNumCol) {
		int oldNumCol = numCol;
		numCol = newNumCol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PSMDocPackage.TABLE__NUM_COL, oldNumCol, numCol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PSMDocPackage.TABLE__ROW:
				return ((InternalEList<?>)getRow()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PSMDocPackage.TABLE__ROW:
				return getRow();
			case PSMDocPackage.TABLE__NUM_ROWS:
				return getNumRows();
			case PSMDocPackage.TABLE__NUM_COL:
				return getNumCol();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PSMDocPackage.TABLE__ROW:
				getRow().clear();
				getRow().addAll((Collection<? extends Row>)newValue);
				return;
			case PSMDocPackage.TABLE__NUM_ROWS:
				setNumRows((Integer)newValue);
				return;
			case PSMDocPackage.TABLE__NUM_COL:
				setNumCol((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PSMDocPackage.TABLE__ROW:
				getRow().clear();
				return;
			case PSMDocPackage.TABLE__NUM_ROWS:
				setNumRows(NUM_ROWS_EDEFAULT);
				return;
			case PSMDocPackage.TABLE__NUM_COL:
				setNumCol(NUM_COL_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PSMDocPackage.TABLE__ROW:
				return row != null && !row.isEmpty();
			case PSMDocPackage.TABLE__NUM_ROWS:
				return numRows != NUM_ROWS_EDEFAULT;
			case PSMDocPackage.TABLE__NUM_COL:
				return numCol != NUM_COL_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (numRows: ");
		result.append(numRows);
		result.append(", numCol: ");
		result.append(numCol);
		result.append(')');
		return result.toString();
	}

} //TableImpl
