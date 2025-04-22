Using the strategy and observer pattern:
For the Strategy pattern I had to create an additional interface named ChangeCalculations 
  and an additional class named GreedyChange, along with some changes to the register class.
  The new interface defines a contract that all change calculation algorithms must implement
  and the new class encapsulates the same algorithm that was in the register class, but now 
  a separate dedicated class.
For the observer pattern I had to create an additional interface named RegisterObserver and
  some changes to the register class and RegisterPanel class files to implement the RegisterObserver
  file. The purpose of the new interface is to standardize how components get change notifications
  The code changes makes it to where the register no longer knows about the UI and the notifications
  can be pre/post notifications now. 
Advantages:
  Strategy Pattern:
  - Can now easily add alternative calculations for the change.
  - Calculation method can be changed at runtime.
  - Better separation
  
  Observer Pattern:
  - The Register no longer need to Control the UI components
  - Has multiple views to observe the same register
  - Reduced coupling between components


