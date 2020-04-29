# SEF-Stock-Market-Project
The Software Engineering Fundamentals Group Project for Surya and Chris at RMIT

This Project is done in Java

This Project will be split up into several key classes:
  StockMarketMain - which initiates on the user's desktop
  StockMarket - which hosts all the users and stocks
  Stock - The container for stocks
  User - the parent to several types of user with different functionality
    Client - interacts by buying, selling, viewing stock and withdrawing funds
      PremiumClient - as above with a Graphical View of the last 30 mins of a given stocks price history
    Auditor - looks through the history of the stockMarket transactions to check for compliance
    Manager - monitors for insider trading, registers users and deposits money into Client stockmarket accounts
  OwnedStock - the stock that is owned by the 
