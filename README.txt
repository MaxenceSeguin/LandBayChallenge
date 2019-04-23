This program matches investments to the loans following the business rules:
 - A valid "funded" loan must be fully funded from the investments.csv file. If a loan does not have all the funds necessary, then it cannot qualify.
     Partially funded loans are of no value to Landbay (we can't give our borrowers less money than they need to buy the property)
 - Over-funded loans are also not useful (we can't give our borrowers more money than they want as this means they will have to eventually pay more interest).
 - If someone wants to invest in TRACKER, you can't place their money into a Loan that is FIXED - and vice-versa.
 - Loans should be processed in the order of their completed date (oldest to newest)
 - The term of the investment must be greater than the term of the loan (i.e. the investor needs to be willing to put money in for longer than the loan needs it for).
 
 How to use the program:
  Step 1. Insert the CSV files containing the loans and the investment in the same directory as LB_challenge.jar.
          The loans file must be named "loans-data.csv". The investments file must be named "investmentRequests-data.csv".
  Step 2. Launch the program.
  Step 3. A file named "Solution.json" will be created. It contains the investments matched to each funded loans.
          If a file with the same name already exists in the folder, it will be overriden to contain the new solution.