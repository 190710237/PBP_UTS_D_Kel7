package com.example.uts_pbp_d_kel7;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class RegisterActivityTest2 {

    @Rule
    public ActivityTestRule<RegisterActivity> mActivityTestRule = new ActivityTestRule<>(RegisterActivity.class);

    @Test
    public void registerActivityTest2() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.btnRegister), withText("Register"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout2),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                1)),
                                6),
                        isDisplayed()));
        materialButton.perform(click());
        onView(isRoot()).perform(waitFor(1500));

        ViewInteraction textInputEditText = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.etFirstName),
                                0),
                        0),
                        isDisplayed()));
        textInputEditText.perform(replaceText("cornelius"), closeSoftKeyboard());



        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.btnRegister), withText("Register"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout2),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                1)),
                                6),
                        isDisplayed()));
        materialButton2.perform(click());
        onView(isRoot()).perform(waitFor(1000));

        ViewInteraction textInputEditText2 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.etLastName),
                                0),
                        1),
                        isDisplayed()));
        textInputEditText2.perform(replaceText("angga"), closeSoftKeyboard());



//        ViewInteraction textInputEditText3 = onView(
//                allOf(childAtPosition(
//                        childAtPosition(
//                                withId(R.id.etEmail),
//                                0),
//                        1),
//                        isDisplayed()));
//        textInputEditText3.perform(click());



        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.btnRegister), withText("Register"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout2),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                1)),
                                6),
                        isDisplayed()));
        materialButton3.perform(click());
        onView(isRoot()).perform(waitFor(1000));

        ViewInteraction textInputEditText4 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.etEmail),
                                0),
                        1),
                        isDisplayed()));
        textInputEditText4.perform(click());

        ViewInteraction textInputEditText5 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.etEmail),
                                0),
                        0),
                        isDisplayed()));
        textInputEditText5.perform(replaceText("endertroller"), closeSoftKeyboard());



        ViewInteraction materialButton4 = onView(
                allOf(withId(R.id.btnRegister), withText("Register"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout2),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                1)),
                                6),
                        isDisplayed()));
        materialButton4.perform(click());
        onView(isRoot()).perform(waitFor(1000));

        ViewInteraction textInputEditText6 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.etUsername),
                                0),
                        1),
                        isDisplayed()));
        textInputEditText6.perform(replaceText("Cipher"), closeSoftKeyboard());



        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.btnRegister), withText("Register"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout2),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                1)),
                                6),
                        isDisplayed()));
        materialButton5.perform(click());
        onView(isRoot()).perform(waitFor(1000));

        ViewInteraction textInputEditText7 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.etPassword),
                                0),
                        1),
                        isDisplayed()));
        textInputEditText7.perform(replaceText("123456"), closeSoftKeyboard());



        ViewInteraction textInputEditText8 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.etConfirmPassword),
                                0),
                        1),
                        isDisplayed()));
        textInputEditText8.perform(replaceText(""), closeSoftKeyboard());


        ViewInteraction materialButton6 = onView(
                allOf(withId(R.id.btnRegister), withText("Register"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout2),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                1)),
                                6),
                        isDisplayed()));
        materialButton6.perform(click());
        onView(isRoot()).perform(waitFor(4000));

        ViewInteraction textInputEditText9 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.etConfirmPassword),
                                0),
                        1),
                        isDisplayed()));
        textInputEditText9.perform(click());

        ViewInteraction textInputEditText10 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.etConfirmPassword),
                                0),
                        0),
                        isDisplayed()));
        textInputEditText10.perform(replaceText("098765"), closeSoftKeyboard());

        ViewInteraction textInputEditText11 = onView(
                allOf(withText("098765"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.etConfirmPassword),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText11.perform(pressImeActionButton());



        ViewInteraction materialButton7 = onView(
                allOf(withId(R.id.btnRegister), withText("Register"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout2),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                1)),
                                6),
                        isDisplayed()));
        materialButton7.perform(click());
        onView(isRoot()).perform(waitFor(3000));

        ViewInteraction textInputEditText12 = onView(
                allOf(withText("098765"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.etConfirmPassword),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText12.perform(click());

        ViewInteraction textInputEditText13 = onView(
                allOf(withText("098765"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.etConfirmPassword),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText13.perform(replaceText("123456"));

        ViewInteraction textInputEditText14 = onView(
                allOf(withText("123456"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.etConfirmPassword),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText14.perform(closeSoftKeyboard());


        ViewInteraction materialButton8 = onView(
                allOf(withId(R.id.btnRegister), withText("Register"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout2),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                1)),
                                6),
                        isDisplayed()));
        materialButton8.perform(click());
        onView(isRoot()).perform(waitFor(5000));

        ViewInteraction textInputEditText15 = onView(
                allOf(withText("Cipher"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.etUsername),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText15.perform(replaceText("cornelius"));

        ViewInteraction textInputEditText16 = onView(
                allOf(withText("cornelius"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.etUsername),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText16.perform(closeSoftKeyboard());

        ViewInteraction textInputEditText17 = onView(
                allOf(withText("endertroller"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.etEmail),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText17.perform(replaceText("vincenthandoko288@gmail.com"));

        ViewInteraction textInputEditText18 = onView(
                allOf(withText("vincenthandoko288@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.etEmail),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText18.perform(closeSoftKeyboard());


        ViewInteraction materialButton9 = onView(
                allOf(withId(R.id.btnRegister), withText("Register"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout2),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                1)),
                                6),
                        isDisplayed()));
        materialButton9.perform(click());
        onView(isRoot()).perform(waitFor(5000));

        ViewInteraction textInputEditText19 = onView(
                allOf(withText("vincenthandoko288@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.etEmail),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText19.perform(click());

        ViewInteraction textInputEditText20 = onView(
                allOf(withText("vincenthandoko288@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.etEmail),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText20.perform(replaceText("endertroller288@gmail.com"));

        ViewInteraction textInputEditText21 = onView(
                allOf(withText("endertroller288@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.etEmail),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText21.perform(closeSoftKeyboard());


        ViewInteraction materialButton10 = onView(
                allOf(withId(R.id.btnRegister), withText("Register"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout2),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                1)),
                                6),
                        isDisplayed()));
        materialButton10.perform(click());
        onView(isRoot()).perform(waitFor(5000));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
    public static ViewAction waitFor(long delay) {
        return new ViewAction() {
            @Override public Matcher<View> getConstraints() {
                return isRoot();
            }
            @Override public String getDescription() {
                return "wait for " + delay + "milliseconds";
            }
            @Override public void perform(UiController uiController,
                                          View view) {
                uiController.loopMainThreadForAtLeast(delay);
            }
        };
    }
}
