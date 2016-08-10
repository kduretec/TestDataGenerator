/**
 */
package PSMDoc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Font Family</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see PSMDoc.PSMDocPackage#getFontFamily()
 * @model
 * @generated
 */
public enum FontFamily implements Enumerator {
	/**
	 * The '<em><b>CALIBRI</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CALIBRI_VALUE
	 * @generated
	 * @ordered
	 */
	CALIBRI(0, "CALIBRI", "CALIBRI"),

	/**
	 * The '<em><b>CENTURY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CENTURY_VALUE
	 * @generated
	 * @ordered
	 */
	CENTURY(1, "CENTURY", "CENTURY"),

	/**
	 * The '<em><b>COURIERNEW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COURIERNEW_VALUE
	 * @generated
	 * @ordered
	 */
	COURIERNEW(2, "COURIERNEW", "COURIERNEW"),

	/**
	 * The '<em><b>TIMESNEWROMAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TIMESNEWROMAN_VALUE
	 * @generated
	 * @ordered
	 */
	TIMESNEWROMAN(3, "TIMESNEWROMAN", "TIMESNEWROMAN"),

	/**
	 * The '<em><b>ARIAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARIAL_VALUE
	 * @generated
	 * @ordered
	 */
	ARIAL(4, "ARIAL", "ARIAL");

	/**
	 * The '<em><b>CALIBRI</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CALIBRI</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CALIBRI
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CALIBRI_VALUE = 0;

	/**
	 * The '<em><b>CENTURY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CENTURY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CENTURY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CENTURY_VALUE = 1;

	/**
	 * The '<em><b>COURIERNEW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COURIERNEW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COURIERNEW
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COURIERNEW_VALUE = 2;

	/**
	 * The '<em><b>TIMESNEWROMAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TIMESNEWROMAN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TIMESNEWROMAN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TIMESNEWROMAN_VALUE = 3;

	/**
	 * The '<em><b>ARIAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARIAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARIAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ARIAL_VALUE = 4;

	/**
	 * An array of all the '<em><b>Font Family</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final FontFamily[] VALUES_ARRAY =
		new FontFamily[] {
			CALIBRI,
			CENTURY,
			COURIERNEW,
			TIMESNEWROMAN,
			ARIAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Font Family</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<FontFamily> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Font Family</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FontFamily get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FontFamily result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Font Family</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FontFamily getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FontFamily result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Font Family</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FontFamily get(int value) {
		switch (value) {
			case CALIBRI_VALUE: return CALIBRI;
			case CENTURY_VALUE: return CENTURY;
			case COURIERNEW_VALUE: return COURIERNEW;
			case TIMESNEWROMAN_VALUE: return TIMESNEWROMAN;
			case ARIAL_VALUE: return ARIAL;
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
	private FontFamily(int value, String name, String literal) {
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
	
} //FontFamily
