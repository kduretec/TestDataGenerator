/**
 */
package benchmarkdp.datagenerator.model.PSMLibre;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Table Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage#getTableType()
 * @model
 * @generated
 */
public enum TableType implements Enumerator {
	/**
	 * The '<em><b>SMALLNUMBERTABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SMALLNUMBERTABLE_VALUE
	 * @generated
	 * @ordered
	 */
	SMALLNUMBERTABLE(0, "SMALLNUMBERTABLE", "SMALLNUMBERTABLE"),

	/**
	 * The '<em><b>ONECOLUMNTABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ONECOLUMNTABLE_VALUE
	 * @generated
	 * @ordered
	 */
	ONECOLUMNTABLE(1, "ONECOLUMNTABLE", "ONECOLUMNTABLE"),

	/**
	 * The '<em><b>BIGNUMBERTABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BIGNUMBERTABLE_VALUE
	 * @generated
	 * @ordered
	 */
	BIGNUMBERTABLE(2, "BIGNUMBERTABLE", "BIGNUMBERTABLE"),

	/**
	 * The '<em><b>TEXTTABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEXTTABLE_VALUE
	 * @generated
	 * @ordered
	 */
	TEXTTABLE(3, "TEXTTABLE", "TEXTTABLE");

	/**
	 * The '<em><b>SMALLNUMBERTABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SMALLNUMBERTABLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SMALLNUMBERTABLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SMALLNUMBERTABLE_VALUE = 0;

	/**
	 * The '<em><b>ONECOLUMNTABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ONECOLUMNTABLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ONECOLUMNTABLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ONECOLUMNTABLE_VALUE = 1;

	/**
	 * The '<em><b>BIGNUMBERTABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BIGNUMBERTABLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BIGNUMBERTABLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BIGNUMBERTABLE_VALUE = 2;

	/**
	 * The '<em><b>TEXTTABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TEXTTABLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TEXTTABLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TEXTTABLE_VALUE = 3;

	/**
	 * An array of all the '<em><b>Table Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TableType[] VALUES_ARRAY =
		new TableType[] {
			SMALLNUMBERTABLE,
			ONECOLUMNTABLE,
			BIGNUMBERTABLE,
			TEXTTABLE,
		};

	/**
	 * A public read-only list of all the '<em><b>Table Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TableType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Table Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TableType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TableType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Table Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TableType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TableType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Table Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TableType get(int value) {
		switch (value) {
			case SMALLNUMBERTABLE_VALUE: return SMALLNUMBERTABLE;
			case ONECOLUMNTABLE_VALUE: return ONECOLUMNTABLE;
			case BIGNUMBERTABLE_VALUE: return BIGNUMBERTABLE;
			case TEXTTABLE_VALUE: return TEXTTABLE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TableType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //TableType
