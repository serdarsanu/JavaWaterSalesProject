package appPack;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public final class DashBoard extends javax.swing.JFrame {
    
    DB db = new DB();
    DefaultTableModel dtmOrder = new DefaultTableModel();
    ArrayList<String> lst = new ArrayList<>();
    Date d = new Date();
    SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
    static String id = "";
    static String name = "";
    static String surname = "";
    static String telephone = "";
    static String address = "";
    static String oid = "";
    static String oname = "";
    static String osurname = "";
    static String ostatus = "";
    static String oaddress = "";
    static String oprice = "";
    String searchName = "";
    String searchSurname = "";
        
    public DashBoard() {
        initComponents();
        txtCName.requestFocus();
        String name ="Welcome " +  Login.name;
        lblAdmin.setText(name);
        tableCustomerResult();
        tableOrderResult();
        lblDate.setText(s.format(d));
        showTime();
    }
    void showTime(){
       new Timer(0, new ActionListener(){
       @Override
       public void actionPerformed(ActionEvent e){
           Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("hh:mm");
        lblTime.setText(s.format(d));
       }
       }).start();
    }
    public void tableCustomerResult(){
        DefaultTableModel dtmCustomer = new DefaultTableModel();
        dtmCustomer.addColumn("ID");
        dtmCustomer.addColumn("Name");
        dtmCustomer.addColumn("Surname");
        dtmCustomer.addColumn("Telephone");
        dtmCustomer.addColumn("Address");
        try {
            String query = "SELECT * FROM `customers`";
            ResultSet rs = db.baglan().executeQuery(query);
            while(rs.next()){
                dtmCustomer.addRow(new String[]{rs.getString("cid"),rs.getString("cname"),
                    rs.getString("csurname"),rs.getString("ctelephone"),rs.getString("caddress")});
            }
            tblCustomer.setModel(dtmCustomer);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Failed to retrieve customer list from database!");
        }
        
    }
    public void tableOrderResult(){
        DefaultTableModel dtmOrder = new DefaultTableModel();
        dtmOrder.addColumn("ID");
        dtmOrder.addColumn("Name");
        dtmOrder.addColumn("Surname");
        dtmOrder.addColumn("Status");
        dtmOrder.addColumn("Address");
        dtmOrder.addColumn("Price");
        try {
            String query = "SELECT * FROM `orders`";
            ResultSet rs = db.baglan().executeQuery(query);
            while(rs.next()){
                dtmOrder.addRow(new String[]{rs.getString("oid"),rs.getString("oname"),
                    rs.getString("osurname"),rs.getString("ostatus"),rs.getString("oaddress"),rs.getString("oprice")});
            }
            tblOrder.setModel(dtmOrder);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Failed to retrieve order list from database!");
        }
        
    }
    public void searchCustomerFunc(){
        if(txtCName.getText().equals("") & txtCSurname.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please enter a name or surname.");
        }else{
            DefaultTableModel dtmSearchCustomer = new DefaultTableModel();
            dtmSearchCustomer.addColumn("ID");
            dtmSearchCustomer.addColumn("Name");
            dtmSearchCustomer.addColumn("Surname");
            dtmSearchCustomer.addColumn("Telephone");
            dtmSearchCustomer.addColumn("Address");
            searchName = txtCName.getText();
            searchSurname = txtCSurname.getText();
            try {
                String query = "SELECT * FROM `customers` WHERE `cname` LIKE '"+searchName+"' OR `csurname` LIKE '"+searchSurname+"'";
                ResultSet rsearch = db.baglan().executeQuery(query);
                while(rsearch.next()){
                    dtmSearchCustomer.addRow(new String[]{rsearch.getString("cid"),rsearch.getString("cname"),
                        rsearch.getString("csurname"),rsearch.getString("ctelephone"),rsearch.getString("caddress")});
                }
                tblCustomer.setModel(dtmSearchCustomer);
                txtCName.setText("");
                txtCSurname.setText("");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Search failed!");
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAdmin = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnNewUser = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtCName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCSurname = new javax.swing.JTextField();
        btnCustomerSearch = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomer = new javax.swing.JTable();
        btnNewCustomer = new javax.swing.JButton();
        btnCustomerEdit = new javax.swing.JButton();
        btnCustomerDelete = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        btnNewOrder = new javax.swing.JButton();
        btnOrderSent = new javax.swing.JButton();
        btnOrderDelivered = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnOrderDelete = new javax.swing.JButton();
        btnOrderDeleteAll = new javax.swing.JButton();
        btnOrderToday = new javax.swing.JButton();
        lblDate = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1380, 830));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(null);

        lblAdmin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblAdmin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lblAdmin);
        lblAdmin.setBounds(945, 0, 199, 34);

        btnExit.setBackground(new java.awt.Color(255, 51, 51));
        btnExit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit);
        btnExit.setBounds(1279, 0, 78, 34);

        btnNewUser.setBackground(new java.awt.Color(204, 255, 255));
        btnNewUser.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnNewUser.setText("New User");
        btnNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewUserActionPerformed(evt);
            }
        });
        getContentPane().add(btnNewUser);
        btnNewUser.setBounds(1162, 0, 99, 34);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 24))); // NOI18N
        jPanel1.setOpaque(false);

        txtCName.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtCName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCNameKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Customer Surname");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Customer Name");

        txtCSurname.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtCSurname.setToolTipText("");
        txtCSurname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCSurnameKeyPressed(evt);
            }
        });

        btnCustomerSearch.setBackground(new java.awt.Color(255, 255, 255));
        btnCustomerSearch.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnCustomerSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/search.png"))); // NOI18N
        btnCustomerSearch.setText("Search");
        btnCustomerSearch.setToolTipText("");
        btnCustomerSearch.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCustomerSearch.setOpaque(false);
        btnCustomerSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCName, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btnCustomerSearch)
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCName, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(txtCSurname))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCustomerSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(12, 41, 692, 137);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 24))); // NOI18N
        jPanel2.setOpaque(false);

        tblCustomer.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tblCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCustomer.setFillsViewportHeight(true);
        tblCustomer.setGridColor(new java.awt.Color(0, 0, 0));
        tblCustomer.setSelectionBackground(new java.awt.Color(102, 204, 255));
        tblCustomer.setUpdateSelectionOnSort(false);
        tblCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCustomer);

        btnNewCustomer.setBackground(new java.awt.Color(255, 255, 255));
        btnNewCustomer.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnNewCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/newCustomer.png"))); // NOI18N
        btnNewCustomer.setText("Add Customer");
        btnNewCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewCustomerActionPerformed(evt);
            }
        });

        btnCustomerEdit.setBackground(new java.awt.Color(255, 255, 255));
        btnCustomerEdit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCustomerEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/editCustomer.png"))); // NOI18N
        btnCustomerEdit.setText("Edit Customer");
        btnCustomerEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerEditActionPerformed(evt);
            }
        });

        btnCustomerDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnCustomerDelete.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCustomerDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/deleteCustomer.png"))); // NOI18N
        btnCustomerDelete.setText("Customer Delete");
        btnCustomerDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerDeleteActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setText("All Customers");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnNewCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCustomerEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCustomerDelete)))
                .addGap(22, 22, 22))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(btnCustomerDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCustomerEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNewCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(12, 196, 692, 594);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Orders", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 24))); // NOI18N
        jPanel3.setOpaque(false);

        tblOrder.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblOrder.setFillsViewportHeight(true);
        tblOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrderMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblOrder);

        btnRefresh.setBackground(new java.awt.Color(255, 255, 255));
        btnRefresh.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnNewOrder.setBackground(new java.awt.Color(255, 255, 255));
        btnNewOrder.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnNewOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/addOrder2.png"))); // NOI18N
        btnNewOrder.setText("Add Order");
        btnNewOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewOrderActionPerformed(evt);
            }
        });

        btnOrderSent.setBackground(new java.awt.Color(255, 255, 255));
        btnOrderSent.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnOrderSent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/sent.png"))); // NOI18N
        btnOrderSent.setText("Sent");
        btnOrderSent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderSentActionPerformed(evt);
            }
        });

        btnOrderDelivered.setBackground(new java.awt.Color(255, 255, 255));
        btnOrderDelivered.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnOrderDelivered.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/delivery.png"))); // NOI18N
        btnOrderDelivered.setText("Delivered");
        btnOrderDelivered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderDeliveredActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnNewOrder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addComponent(btnOrderSent, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnOrderDelivered))
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNewOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnOrderDelivered, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOrderSent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(711, 196, 646, 588);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Order Table Operations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 24))); // NOI18N
        jPanel4.setOpaque(false);

        btnOrderDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnOrderDelete.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnOrderDelete.setText("Delete Selected");
        btnOrderDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderDeleteActionPerformed(evt);
            }
        });

        btnOrderDeleteAll.setBackground(new java.awt.Color(255, 255, 255));
        btnOrderDeleteAll.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnOrderDeleteAll.setText("Delete All");
        btnOrderDeleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderDeleteAllActionPerformed(evt);
            }
        });

        btnOrderToday.setBackground(new java.awt.Color(255, 255, 255));
        btnOrderToday.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnOrderToday.setText("Today's Orders");
        btnOrderToday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderTodayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnOrderDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOrderDeleteAll, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOrderToday, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOrderDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOrderDeleteAll, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOrderToday, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(711, 41, 646, 137);

        lblDate.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblDate);
        lblDate.setBounds(12, 8, 144, 26);

        lblTime.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        getContentPane().add(lblTime);
        lblTime.setBounds(199, 9, 128, 25);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("|");
        jLabel3.setAlignmentY(0.0F);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(162, 0, 25, 34);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/WaterBackground.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(-10, -10, 1590, 930);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int answer = JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",JOptionPane.YES_NO_OPTION);
        if (answer == 0){
            System.exit(0);
        }   
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnNewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewUserActionPerformed
        AddUser au = new AddUser();
        au.setVisible(true);
    }//GEN-LAST:event_btnNewUserActionPerformed

    private void btnCustomerSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerSearchActionPerformed
        searchCustomerFunc();
    }//GEN-LAST:event_btnCustomerSearchActionPerformed

    private void btnNewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewOrderActionPerformed
        if(id.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please select the customer to new order from the customer table.");
        }else{
            NewOrder no = new NewOrder();
            no.setVisible(true);
        }
    }//GEN-LAST:event_btnNewOrderActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        tableOrderResult();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnOrderSentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderSentActionPerformed
        if(oid.equals("")){
            JOptionPane.showMessageDialog(rootPane,"Please select the status to edit from the order table.");
        }else{
            try {
            DB db = new DB();
            String query = "UPDATE `orders` SET `oname` = '"+oname+"', `osurname` = '"+osurname+"', "
                    + "`ostatus` = 'Sent', `oaddress` = '"+oaddress+"', `oprice` = '"+oprice+"' "
                    + "WHERE `orders`.`oid` = '"+DashBoard.oid+"'";
            int add = db.baglan().executeUpdate(query);
            if(add > 0){
                tableOrderResult();
                JOptionPane.showMessageDialog(rootPane, "Status Edited.");
            }else{
                JOptionPane.showMessageDialog(rootPane, "Customer could not be edited status.");
            }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Edited Status Failed : ");
            }
        }
        oid = "";
    }//GEN-LAST:event_btnOrderSentActionPerformed

    private void tblOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderMouseClicked
        int row2 = tblOrder.getSelectedRow();
        oid = "" + tblOrder.getValueAt(row2,0);
        oname = "" + tblOrder.getValueAt(row2,1);
        osurname = "" + tblOrder.getValueAt(row2,2);
        oaddress = "" + tblOrder.getValueAt(row2,4);
        oprice = "" + tblOrder.getValueAt(row2,5);
    }//GEN-LAST:event_tblOrderMouseClicked

    private void btnOrderDeliveredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderDeliveredActionPerformed
       if(oid.equals("")){
            JOptionPane.showMessageDialog(rootPane,"Please select the status to edit from the order table.");
        }else{
            try {
            DB db = new DB();
            String query = "UPDATE `orders` SET `oname` = '"+oname+"', `osurname` = '"+osurname+"', "
                    + "`ostatus` = 'Delivered', `oaddress` = '"+oaddress+"', `oprice` = '"+oprice+"' "
                    + "WHERE `orders`.`oid` = '"+DashBoard.oid+"'";
            int add = db.baglan().executeUpdate(query);
            if(add > 0){
                tableOrderResult();
                JOptionPane.showMessageDialog(rootPane, "Status Edited.");
            }else{
                JOptionPane.showMessageDialog(rootPane, "Customer could not be edited status.");
            }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Edited Status Failed : ");
            }
        }
        oid = "";
    }//GEN-LAST:event_btnOrderDeliveredActionPerformed

    private void btnOrderDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderDeleteActionPerformed
        if(oid.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please select the order to delete from the order table.");
        }else{
            int answer = JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",JOptionPane.YES_NO_OPTION);
            if(answer == 0){
                try {
                    String query = "DELETE FROM `orders` WHERE `orders`.`oid` = "+oid+"";
                    int sonuc = db.baglan().executeUpdate(query);
                    if(sonuc > 0){
                        tableOrderResult();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "Delete Fail!");
                }
            }
        }
        oid = "";
    }//GEN-LAST:event_btnOrderDeleteActionPerformed

    private void btnOrderDeleteAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderDeleteAllActionPerformed
        int answer = JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",JOptionPane.YES_NO_OPTION);
        if (answer == 0){
            try {
                String query = "DELETE FROM `orders`";
                int sonuc = db.baglan().executeUpdate(query);
                if(sonuc > 0){
                    JOptionPane.showMessageDialog(rootPane, "All Orders Deleted.");
                    tableCustomerResult();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Fail to delete orders.");
            }
        }
    }//GEN-LAST:event_btnOrderDeleteAllActionPerformed

    private void btnOrderTodayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderTodayActionPerformed
        String nowDate = s.format(d);
        DefaultTableModel dtmTodayOrder = new DefaultTableModel();
        dtmTodayOrder.addColumn("ID");
        dtmTodayOrder.addColumn("Name");
        dtmTodayOrder.addColumn("Surname");
        dtmTodayOrder.addColumn("Status");
        dtmTodayOrder.addColumn("Address");
        dtmTodayOrder.addColumn("Price");
        try {
            String query = "SELECT * FROM `orders` WHERE `odate` LIKE '"+nowDate+"'";
            ResultSet rs = db.baglan().executeQuery(query);
            while(rs.next()){
                dtmTodayOrder.addRow(new String[]{rs.getString("oid"),rs.getString("oname"),
                    rs.getString("osurname"),rs.getString("ostatus"),rs.getString("oaddress"),rs.getString("oprice")});
            }
            tblOrder.setModel(dtmTodayOrder);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "No Order Today!");
        }
    }//GEN-LAST:event_btnOrderTodayActionPerformed

    private void txtCSurnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCSurnameKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){  
            searchCustomerFunc();
        }
    }//GEN-LAST:event_txtCSurnameKeyPressed

    private void txtCNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCNameKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){  
            searchCustomerFunc();
        }
    }//GEN-LAST:event_txtCNameKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tableCustomerResult();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCustomerDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerDeleteActionPerformed
        if(id.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please select the customer to delete from the customer table.");
        }else{
            int answer = JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",JOptionPane.YES_NO_OPTION);
            if (answer == 0){
                try {
                    String query = "DELETE FROM `customers` WHERE `customers`.`cid` = "+id+"";
                    int sonuc = db.baglan().executeUpdate(query);
                    if(sonuc > 0){
                        JOptionPane.showMessageDialog(rootPane, "Customers Deleted.");
                        tableCustomerResult();
                        id = "";
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "Fail to delete customer.");
                }
            }
        }
    }//GEN-LAST:event_btnCustomerDeleteActionPerformed

    private void btnCustomerEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerEditActionPerformed
        if(id.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please select the customer to edit from the table.");
        }else{
            CustomerEdit ce = new CustomerEdit();
            ce.setVisible(true);
        }
    }//GEN-LAST:event_btnCustomerEditActionPerformed

    private void btnNewCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewCustomerActionPerformed
        NewCustomer nc = new NewCustomer();
        nc.setVisible(true);
    }//GEN-LAST:event_btnNewCustomerActionPerformed

    private void tblCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomerMouseClicked
        int row = tblCustomer.getSelectedRow();
        id = "" + tblCustomer.getValueAt(row,0);
        name = "" + tblCustomer.getValueAt(row,1);
        surname = "" + tblCustomer.getValueAt(row,2);
        telephone = "" + tblCustomer.getValueAt(row,3);
        address = "" + tblCustomer.getValueAt(row,4);
    }//GEN-LAST:event_tblCustomerMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCustomerDelete;
    private javax.swing.JButton btnCustomerEdit;
    private javax.swing.JButton btnCustomerSearch;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnNewCustomer;
    private javax.swing.JButton btnNewOrder;
    private javax.swing.JButton btnNewUser;
    private javax.swing.JButton btnOrderDelete;
    private javax.swing.JButton btnOrderDeleteAll;
    private javax.swing.JButton btnOrderDelivered;
    private javax.swing.JButton btnOrderSent;
    private javax.swing.JButton btnOrderToday;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblTime;
    public javax.swing.JTable tblCustomer;
    public javax.swing.JTable tblOrder;
    private javax.swing.JTextField txtCName;
    private javax.swing.JTextField txtCSurname;
    // End of variables declaration//GEN-END:variables
}
