package com.example.uts_pbp_d_kel7;


import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static androidx.test.InstrumentationRegistry.getInstrumentation;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import com.example.uts_pbp_d_kel7.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class RegisterActivityTest {

    @Rule
    public ActivityTestRule<RegisterActivity> mActivityTestRule = new ActivityTestRule<>(RegisterActivity.class);

    @Test
    public void registerActivityTest() {
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
                        1),
                        isDisplayed()));
        textInputEditText.perform(replaceText("Cornelius"), closeSoftKeyboard());

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
        onView(isRoot()).perform(waitFor(1500));

        ViewInteraction textInputEditText2 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.etLastName),
                                0),
                        1),
                        isDisplayed()));
        textInputEditText2.perform(replaceText("Angga"), closeSoftKeyboard());


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
        onView(isRoot()).perform(waitFor(1500));

        ViewInteraction textInputEditText3 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.etUsername),
                                0),
                        1),
                        isDisplayed()));
        textInputEditText3.perform(replaceText("Test"), closeSoftKeyboard());


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
        onView(isRoot()).perform(waitFor(1500));

        ViewInteraction textInputEditText4 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.etPassword),
                                0),
                        1),
                        isDisplayed()));
        textInputEditText4.perform(replaceText("123456"), closeSoftKeyboard());


        ViewInteraction textInputEditText5 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.etConfirmPassword),
                                0),
                        1),
                        isDisplayed()));
        textInputEditText5.perform(replaceText("12345"), closeSoftKeyboard());


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
        onView(isRoot()).perform(waitFor(1500));

        ViewInteraction textInputEditText6 = onView(
                allOf(withText("12345"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.etConfirmPassword),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText6.perform(click());

        ViewInteraction textInputEditText7 = onView(
                allOf(withText("12345"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.etConfirmPassword),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText7.perform(replaceText("123456"));

        ViewInteraction textInputEditText8 = onView(
                allOf(withText("123456"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.etConfirmPassword),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText8.perform(closeSoftKeyboard());


        ViewInteraction textInputEditText9 = onView(
                allOf(withText("amadeusryanwijaya8@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.etEmail),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText9.perform(replaceText("amadeusryanwijaya8@gmail"));

        ViewInteraction textInputEditText10 = onView(
                allOf(withText("amadeusryanwijaya8@gmail"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.etEmail),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText10.perform(closeSoftKeyboard());



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
        onView(isRoot()).perform(waitFor(5000));

        ViewInteraction textInputEditText11 = onView(
                allOf(withText("amadeusryanwijaya8@gmail"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.etEmail),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText11.perform(click());

        ViewInteraction textInputEditText12 = onView(
                allOf(withText("amadeusryanwijaya8@gmail"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.etEmail),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText12.perform(replaceText("amadeusryanwijaya8@gmail.com"));

        ViewInteraction textInputEditText13 = onView(
                allOf(withText("amadeusryanwijaya8@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.etEmail),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText13.perform(closeSoftKeyboard());



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
        onView(isRoot()).perform(waitFor(5000));

        ViewInteraction textInputEditText14 = onView(
                allOf(withText("amadeusryanwijaya8@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.etEmail),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText14.perform(click());

        ViewInteraction textInputEditText15 = onView(
                allOf(withText("amadeusryanwijaya8@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.etEmail),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText15.perform(replaceText("mooncell777@gmail.com"));

        ViewInteraction textInputEditText19 = onView(
                allOf(withText("mooncell777@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.etEmail),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText19.perform(closeSoftKeyboard());

        ViewInteraction textInputEditText20 = onView(
                allOf(withText("Test"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.etUsername),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText20.perform(longClick());

        ViewInteraction textInputEditText21 = onView(
                allOf(withText("Test"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.etUsername),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText21.perform(replaceText("Cipher"));

        ViewInteraction textInputEditText25 = onView(
                allOf(withText("Cipher"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.etUsername),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText25.perform(closeSoftKeyboard());



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

        ViewInteraction textInputEditText26 = onView(
                allOf(withText("Cipher"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.etUsername),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText26.perform(click());

        ViewInteraction textInputEditText27 = onView(
                allOf(withText("Cipher"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.etUsername),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText27.perform(click());

        ViewInteraction textInputEditText28 = onView(
                allOf(withText("Cipher"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.etUsername),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText28.perform(longClick());

        ViewInteraction textInputEditText29 = onView(
                allOf(withText("Cipher"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.etUsername),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText29.perform(replaceText("MoonCell"));

        ViewInteraction textInputEditText30 = onView(
                allOf(withText("MoonCell"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.etUsername),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText30.perform(closeSoftKeyboard());



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
