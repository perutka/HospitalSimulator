package com.pperusek.edgetech.interfaces;

import com.pperusek.edgetech.enums.Drug;
import com.pperusek.edgetech.enums.PatientState;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link PatientsTreatment}.
 * <p>
 * Use the static factory method to create immutable instances:
 * {@code ImmutablePatientsTreatment.of()}.
 */
@Generated(from = "PatientsTreatment", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutablePatientsTreatment implements PatientsTreatment {
  private final List<PatientState> patientsStates;
  private final List<Drug> tretmentDrug;

  private ImmutablePatientsTreatment(
      Iterable<? extends PatientState> patientsStates,
      Iterable<? extends Drug> tretmentDrug) {
    this.patientsStates = createUnmodifiableList(false, createSafeList(patientsStates, true, false));
    this.tretmentDrug = createUnmodifiableList(false, createSafeList(tretmentDrug, true, false));
  }

  private ImmutablePatientsTreatment(
      ImmutablePatientsTreatment original,
      List<PatientState> patientsStates,
      List<Drug> tretmentDrug) {
    this.patientsStates = patientsStates;
    this.tretmentDrug = tretmentDrug;
  }

  /**
   * @return The value of the {@code patientsStates} attribute
   */
  @Override
  public List<PatientState> getPatientsStates() {
    return patientsStates;
  }

  /**
   * @return The value of the {@code tretmentDrug} attribute
   */
  @Override
  public List<Drug> getTretmentDrug() {
    return tretmentDrug;
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link PatientsTreatment#getPatientsStates() patientsStates}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutablePatientsTreatment withPatientsStates(PatientState... elements) {
    List<PatientState> newValue = createUnmodifiableList(false, createSafeList(Arrays.asList(elements), true, false));
    return new ImmutablePatientsTreatment(this, newValue, this.tretmentDrug);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link PatientsTreatment#getPatientsStates() patientsStates}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of patientsStates elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutablePatientsTreatment withPatientsStates(Iterable<? extends PatientState> elements) {
    if (this.patientsStates == elements) return this;
    List<PatientState> newValue = createUnmodifiableList(false, createSafeList(elements, true, false));
    return new ImmutablePatientsTreatment(this, newValue, this.tretmentDrug);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link PatientsTreatment#getTretmentDrug() tretmentDrug}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutablePatientsTreatment withTretmentDrug(Drug... elements) {
    List<Drug> newValue = createUnmodifiableList(false, createSafeList(Arrays.asList(elements), true, false));
    return new ImmutablePatientsTreatment(this, this.patientsStates, newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link PatientsTreatment#getTretmentDrug() tretmentDrug}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of tretmentDrug elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutablePatientsTreatment withTretmentDrug(Iterable<? extends Drug> elements) {
    if (this.tretmentDrug == elements) return this;
    List<Drug> newValue = createUnmodifiableList(false, createSafeList(elements, true, false));
    return new ImmutablePatientsTreatment(this, this.patientsStates, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutablePatientsTreatment} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutablePatientsTreatment
        && equalTo((ImmutablePatientsTreatment) another);
  }

  private boolean equalTo(ImmutablePatientsTreatment another) {
    return patientsStates.equals(another.patientsStates)
        && tretmentDrug.equals(another.tretmentDrug);
  }

  /**
   * Computes a hash code from attributes: {@code patientsStates}, {@code tretmentDrug}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + patientsStates.hashCode();
    h += (h << 5) + tretmentDrug.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code PatientsTreatment} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "PatientsTreatment{"
        + "patientsStates=" + patientsStates
        + ", tretmentDrug=" + tretmentDrug
        + "}";
  }

  /**
   * Construct a new immutable {@code PatientsTreatment} instance.
   * @param patientsStates The value for the {@code patientsStates} attribute
   * @param tretmentDrug The value for the {@code tretmentDrug} attribute
   * @return An immutable PatientsTreatment instance
   */
  public static ImmutablePatientsTreatment of(List<PatientState> patientsStates, List<Drug> tretmentDrug) {
    return of((Iterable<? extends PatientState>) patientsStates, (Iterable<? extends Drug>) tretmentDrug);
  }

  /**
   * Construct a new immutable {@code PatientsTreatment} instance.
   * @param patientsStates The value for the {@code patientsStates} attribute
   * @param tretmentDrug The value for the {@code tretmentDrug} attribute
   * @return An immutable PatientsTreatment instance
   */
  public static ImmutablePatientsTreatment of(Iterable<? extends PatientState> patientsStates, Iterable<? extends Drug> tretmentDrug) {
    return new ImmutablePatientsTreatment(patientsStates, tretmentDrug);
  }

  /**
   * Creates an immutable copy of a {@link PatientsTreatment} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable PatientsTreatment instance
   */
  public static ImmutablePatientsTreatment copyOf(PatientsTreatment instance) {
    if (instance instanceof ImmutablePatientsTreatment) {
      return (ImmutablePatientsTreatment) instance;
    }
    return ImmutablePatientsTreatment.of(instance.getPatientsStates(), instance.getTretmentDrug());
  }

  private static <T> List<T> createSafeList(Iterable<? extends T> iterable, boolean checkNulls, boolean skipNulls) {
    ArrayList<T> list;
    if (iterable instanceof Collection<?>) {
      int size = ((Collection<?>) iterable).size();
      if (size == 0) return Collections.emptyList();
      list = new ArrayList<>();
    } else {
      list = new ArrayList<>();
    }
    for (T element : iterable) {
      if (skipNulls && element == null) continue;
      if (checkNulls) Objects.requireNonNull(element, "element");
      list.add(element);
    }
    return list;
  }

  private static <T> List<T> createUnmodifiableList(boolean clone, List<T> list) {
    switch(list.size()) {
    case 0: return Collections.emptyList();
    case 1: return Collections.singletonList(list.get(0));
    default:
      if (clone) {
        return Collections.unmodifiableList(new ArrayList<>(list));
      } else {
        if (list instanceof ArrayList<?>) {
          ((ArrayList<?>) list).trimToSize();
        }
        return Collections.unmodifiableList(list);
      }
    }
  }
}
