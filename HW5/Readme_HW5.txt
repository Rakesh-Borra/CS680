Extended (HW4) JointBankAccount of a family to use many-to-many event notifications and implemented Multicast Design Pattern.

Scenario: parents wants children to not see about the credit transaction but only the debit transactions happening in the joint account or may allow children to see the both credit and debit as per their convinient.
In this case, we are implementing the Multicast Observer Design Pattern by having different types of events (credit and debit) and handling them separately while allowing multiple observers(members) to subscribe and receive notifications for each event type.
This means that an observer can receive notifications for both credit and debit events independently, depending on what they subscribe to.