package com.pperusek.edgetech.interfaces;

import com.pperusek.edgetech.enums.Drug;
import com.pperusek.edgetech.enums.PatientState;
import java.util.List;
import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link Transition}.
 * <p>
 * Use the static factory method to create immutable instances:
 * {@code ImmutableTransition.of()}.
 */
@Generated(from = "Transition", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableTransition extends Transition {
  private final Transition.Matcher<PatientState> initStateMatcher;
  private final Transition.Matcher<List<Drug>> drugMatcher;
  private final PatientState endState;

  private ImmutableTransition(
      Transition.Matcher<PatientState> initStateMatcher,
      Transition.Matcher<List<Drug>> drugMatcher,
      PatientState endState) {
    this.initStateMatcher = Objects.requireNonNull(initStateMatcher, "initStateMatcher");
    this.drugMatcher = Objects.requireNonNull(drugMatcher, "drugMatcher");
    this.endState = Objects.requireNonNull(endState, "endState");
  }

  private ImmutableTransition(
      ImmutableTransition original,
      Transition.Matcher<PatientState> initStateMatcher,
      Transition.Matcher<List<Drug>> drugMatcher,
      PatientState endState) {
    this.initStateMatcher = initStateMatcher;
    this.drugMatcher = drugMatcher;
    this.endState = endState;
  }

  /**
   * @return The value of the {@code initStateMatcher} attribute
   */
  @Override
  public Transition.Matcher<PatientState> getInitStateMatcher() {
    return initStateMatcher;
  }

  /**
   * @return The value of the {@code drugMatcher} attribute
   */
  @Override
  public Transition.Matcher<List<Drug>> getDrugMatcher() {
    return drugMatcher;
  }

  /**
   * @return The value of the {@code endState} attribute
   */
  @Override
  public PatientState getEndState() {
    return endState;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Transition#getInitStateMatcher() initStateMatcher} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for initStateMatcher
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableTransition withInitStateMatcher(Transition.Matcher<PatientState> value) {
    if (this.initStateMatcher == value) return this;
    Transition.Matcher<PatientState> newValue = Objects.requireNonNull(value, "initStateMatcher");
    return new ImmutableTransition(this, newValue, this.drugMatcher, this.endState);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Transition#getDrugMatcher() drugMatcher} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for drugMatcher
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableTransition withDrugMatcher(Transition.Matcher<List<Drug>> value) {
    if (this.drugMatcher == value) return this;
    Transition.Matcher<List<Drug>> newValue = Objects.requireNonNull(value, "drugMatcher");
    return new ImmutableTransition(this, this.initStateMatcher, newValue, this.endState);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Transition#getEndState() endState} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for endState
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableTransition withEndState(PatientState value) {
    if (this.endState == value) return this;
    PatientState newValue = Objects.requireNonNull(value, "endState");
    if (this.endState.equals(newValue)) return this;
    return new ImmutableTransition(this, this.initStateMatcher, this.drugMatcher, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableTransition} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableTransition
        && equalTo((ImmutableTransition) another);
  }

  private boolean equalTo(ImmutableTransition another) {
    return initStateMatcher.equals(another.initStateMatcher)
        && drugMatcher.equals(another.drugMatcher)
        && endState.equals(another.endState);
  }

  /**
   * Computes a hash code from attributes: {@code initStateMatcher}, {@code drugMatcher}, {@code endState}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + initStateMatcher.hashCode();
    h += (h << 5) + drugMatcher.hashCode();
    h += (h << 5) + endState.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Transition} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Transition{"
        + "initStateMatcher=" + initStateMatcher
        + ", drugMatcher=" + drugMatcher
        + ", endState=" + endState
        + "}";
  }

  /**
   * Construct a new immutable {@code Transition} instance.
   * @param initStateMatcher The value for the {@code initStateMatcher} attribute
   * @param drugMatcher The value for the {@code drugMatcher} attribute
   * @param endState The value for the {@code endState} attribute
   * @return An immutable Transition instance
   */
  public static ImmutableTransition of(Transition.Matcher<PatientState> initStateMatcher, Transition.Matcher<List<Drug>> drugMatcher, PatientState endState) {
    return new ImmutableTransition(initStateMatcher, drugMatcher, endState);
  }

  /**
   * Creates an immutable copy of a {@link Transition} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Transition instance
   */
  public static ImmutableTransition copyOf(Transition instance) {
    if (instance instanceof ImmutableTransition) {
      return (ImmutableTransition) instance;
    }
    return ImmutableTransition.of(instance.getInitStateMatcher(), instance.getDrugMatcher(), instance.getEndState());
  }
}
