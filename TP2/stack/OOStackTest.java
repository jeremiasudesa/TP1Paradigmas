package stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class OOStackTest {

	private static final String expectedMessageNotUnderstood = "Expected MessageNotUnderstood Error was not thrown.";
	private static final String textToTest1 = "Text1";
	private static final String textToTest2 = "Text2";

	@Test
	public void test01StackShouldBeEmptyWhenCreated() {
		assertTrue(new OOStack().isEmpty());
	}

	@Test
	public void test02PushAddElementsToTheStack() {
		assertFalse(new OOStack().push(textToTest1).isEmpty());
	}

	@Test
	public void test03PopRemovesElementsFromTheStack() {
		OOStack stack = stackThatHadSomething();
		assertTrue(stack.isEmpty());
	}

	@Test
	public void test04PopReturnsLastPushedObject() {
		OOStack stack = stackWithOneText();
		assertEquals(stack.pop(), textToTest1);
	}

	@Test
	public void test05StackBehavesLIFO() {
		OOStack stack = stackWithTwoTexts();
		assertEquals(stack.pop(), textToTest2);
		assertEquals(stack.pop(), textToTest1);
		assertTrue(stack.isEmpty());
	}

	@Test
	public void test06TopReturnsLastPushedObject() {
		assertEquals(stackWithOneText().top(), textToTest1);
	}

	@Test
	public void test07TopDoesNotRemoveObjectFromStack() {
		OOStack stack = stackWithOneText();
		assertEquals(stack.size(), 1);
		stack.top();
		assertEquals(stack.size(), 1);
	}

	@Test
	public void test08CanNotPopWhenThereAreNoObjectsInTheStack() {
		OOStack stack = new OOStack();
		throwsStackEmpty(stack);
	}

	@Test
	public void test09CanNotPopWhenThereAreNoObjectsInTheStackAndTheStackHadObjects() {
		OOStack stack = stackThatHadSomething();
		throwsStackEmpty(stack);
	}

	@Test
	public void test10CanNotTopWhenThereAreNoObjectsInTheStack() {
		OOStack stack = new OOStack();
		throwsStackEmpty(stack);
	}

	private void throwsStackEmpty(OOStack stack) {
		assertThrowsLike(OOStack.stackEmptyErrorDescription, () -> {
			stack.pop();
			fail(expectedMessageNotUnderstood);
		});
	}

	private OOStack stackThatHadSomething() {

		OOStack stack = stackWithOneText();
		stack.pop();
		return stack;
	}

	private OOStack stackWithOneText() {
		return new OOStack().push(textToTest1);
	}

	private OOStack stackWithTwoTexts() {
		return stackWithOneText().push(textToTest2);
	}

	private void assertThrowsLike(String msg, Executable lambda) {
		assertEquals(msg, assertThrows(Error.class, lambda).getMessage());
	}
}