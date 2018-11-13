/**
 */
package benchmarkdp.datagenerator.model.PSMDocx.impl;

import benchmarkdp.datagenerator.model.PSMDocx.PSMDocxPackage;
import benchmarkdp.datagenerator.model.PSMDocx.Row;
import benchmarkdp.datagenerator.model.PSMDocx.TableImpl;

import benchmarkdp.datagenerator.model.PSMDocx.TableType;
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
 * An implementation of the model object '<em><b>Table Impl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMDocx.impl.TableImplImpl#getRow <em>Row</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMDocx.impl.TableImplImpl#getNumRows <em>Num Rows</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMDocx.impl.TableImplImpl#getNumCol <em>Num Col</em>}</li>
 *   <li>{@link benchmarkdp.datagenerator.model.PSMDocx.impl.TableImplImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class TableImplImpl extends TextContainerImpl implements TableImpl {
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
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final TableType TYPE_EDEFAULT = TableType.SMALLNUMBERTABLE;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected TableType type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TableImplImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PSMDocxPackage.Literals.TABLE_IMPL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Row> getRow() {
		if (row == null) {
			row = new EObjectContainmentEList<Row>(Row.class, this, PSMDocxPackage.TABLE_IMPL__ROW);
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
			eNotify(new ENotificationImpl(this, Notification.SET, PSMDocxPackage.TABLE_IMPL__NUM_ROWS, oldNumRows, numRows));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PSMDocxPackage.TABLE_IMPL__NUM_COL, oldNumCol, numCol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(TableType newType) {
		TableType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PSMDocxPackage.TABLE_IMPL__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PSMDocxPackage.TABLE_IMPL__ROW:
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
			case PSMDocxPackage.TABLE_IMPL__ROW:
				return getRow();
			case PSMDocxPackage.TABLE_IMPL__NUM_ROWS:
				return getNumRows();
			case PSMDocxPackage.TABLE_IMPL__NUM_COL:
				return getNumCol();
			case PSMDocxPackage.TABLE_IMPL__TYPE:
				return getType();
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
			case PSMDocxPackage.TABLE_IMPL__ROW:
				getRow().clear();
				getRow().addAll((Collection<? extends Row>)newValue);
				return;
			case PSMDocxPackage.TABLE_IMPL__NUM_ROWS:
				setNumRows((Integer)newValue);
				return;
			case PSMDocxPackage.TABLE_IMPL__NUM_COL:
				setNumCol((Integer)newValue);
				return;
			case PSMDocxPackage.TABLE_IMPL__TYPE:
				setType((TableType)newValue);
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
			case PSMDocxPackage.TABLE_IMPL__ROW:
				getRow().clear();
				return;
			case PSMDocxPackage.TABLE_IMPL__NUM_ROWS:
				setNumRows(NUM_ROWS_EDEFAULT);
				return;
			case PSMDocxPackage.TABLE_IMPL__NUM_COL:
				setNumCol(NUM_COL_EDEFAULT);
				return;
			case PSMDocxPackage.TABLE_IMPL__TYPE:
				setType(TYPE_EDEFAULT);
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
			case PSMDocxPackage.TABLE_IMPL__ROW:
				return row != null && !row.isEmpty();
			case PSMDocxPackage.TABLE_IMPL__NUM_ROWS:
				return numRows != NUM_ROWS_EDEFAULT;
			case PSMDocxPackage.TABLE_IMPL__NUM_COL:
				return numCol != NUM_COL_EDEFAULT;
			case PSMDocxPackage.TABLE_IMPL__TYPE:
				return type != TYPE_EDEFAULT;
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
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //TableImplImpl
