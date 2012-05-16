#!/usr/bin/perl
#
# Site specific customizations section
my $sg_server = "sg-hub.oceanobservatories.org";
my $target_base = "http://ion-beta.oceanobservatories.org/";
#my $target_base = "http://67.58.40.163:3000/";

my %browser;
#   $browser{'Windows7'} 		= ['IE', 'Firefox'];
#   $browser{'Windows XP'} 	= ['IE', 'Firefox'];
#   $browser{'Windows Vista'} 	= ['IE', 'Firefox'];
   $browser{'Linux'} 			= ['Firefox'];
   $browser{'OS X'} 			= ['Safari', 'Firefox'];
# above browsers comments leaves only 2sys with 3-browsers
# so, UIDs used are only: OOICI.Test, OOICI.Test1, OOICI.Test2   

# my $generic_password = 'zootester63';

# Accounts
  
   my $generic_password = 'BubbleEconomy2015'; 
   my %account;
   
   #$account{'new_user'}[0]{'name'} = 'zootester63';
   #$account{'new_user'}[0]{'password'} = $generic_password;
   #$account{'new_user'}[0]{'account_name'} = 'Zoo Test1';

   #$account{'administrator'}[0]{'name'} = 'testerfor.ooici@gmail.com';
   #$account{'administrator'}[0]{'password'} = $generic_password;
   #$account{'administrator'}[0]{'account_name'} = 'OOICI Testing Admin';

   $account{'new_user'}[0]{'name'} = 'OOICI.Test@gmail.com';
   $account{'new_user'}[0]{'password'} = $generic_password;
   $account{'new_user'}[0]{'account_name'} = 'OOICI Test';

   $account{'new_user'}[1]{'name'} = 'OOICI.Test1@gmail.com';
   $account{'new_user'}[1]{'password'} = $generic_password;
   $account{'new_user'}[1]{'account_name'} = 'OOICI Test1';
   
   $account{'new_user'}[2]{'name'} = 'OOICI.Test2@gmail.com';
   $account{'new_user'}[2]{'password'} = $generic_password;
   $account{'new_user'}[2]{'account_name'} = 'OOICI Test2';
   
   $account{'new_user'}[3]{'name'} = 'OOICI.Test3@gmail.com';
   $account{'new_user'}[3]{'password'} = $generic_password;
   $account{'new_user'}[3]{'account_name'} = 'OOICI Test3';
   
   $account{'new_user'}[4]{'name'} = 'OOICI.Test4@gmail.com';
   $account{'new_user'}[4]{'password'} = $generic_password;
   $account{'new_user'}[4]{'account_name'} = 'OOICI Test4';
   
   $account{'new_user'}[5]{'name'} = 'OOICI.Test5@gmail.com';
   $account{'new_user'}[5]{'password'} = $generic_password;
   $account{'new_user'}[5]{'account_name'} = 'OOICI Test5';
   
   $account{'new_user'}[6]{'name'} = 'OOICI.Test6@gmail.com';
   $account{'new_user'}[6]{'password'} = $generic_password;
   $account{'new_user'}[6]{'account_name'} = 'OOICI Test6';
   
   $account{'new_user'}[7]{'name'} = 'OOICI.Test7@gmail.com';
   $account{'new_user'}[7]{'password'} = $generic_password;
   $account{'new_user'}[7]{'account_name'} = 'OOICI Test7';
   
   $account{'new_user'}[8]{'name'} = 'OOICI.Test8@gmail.com';
   $account{'new_user'}[8]{'password'} = $generic_password;
   $account{'new_user'}[8]{'account_name'} = 'OOICI Test8';

############################################

# Handle each file on the command line
foreach $fn (@ARGV) {
  my $script = "";
  my $try_count = 0;
  print STDERR "Processing  $fn \n";
  open(FILE, $fn) || die "cannot open file $fn\n";
  while (<FILE>) {
    s/^\s*package com.example.tests;$//;
    $script .= $_;
  }
  close(FILE);

  for $f (keys %browser ) {
    for $i ( 0 .. $#{ $browser{$f} } ) {
      
      print STDERR "    OUTPUTTING browser specific script for: $browser{$f}[$i] on $f\n";
      
        $ofn = $fn;
        $ofn =~ s#^rel1_testcases.*/#generated_tests/#;
        $ofn =~ s#(\.java)#_$browser{$f}[$i] on $f$1#;
        $ofn =~ s/ /_/g;
        open(OUT, ">$ofn") || die "cannot open outfile $ofn\n";
        my $script_copy = $script;
  
        # Modify the command to work without selenium grid setup
        my $platform = "$browser{$f}[$i] on $f";
        my $sg_server = "sg-hub.oceanobservatories.org";
        my $target_base = "http://ion-beta.oceanobservatories.org/";
     
        $script_copy =~ s/selenium = new DefaultSelenium\("([^"]+)", 4444, "([^"]+)", "([^"]+)"\);/selenium = new DefaultSelenium("$sg_server", 4444, "$platform", "$target_base");/m;
  
        # Now edit-in the new username and password 
        $script_copy =~ s/U_S_E_R-N_A_M_E/$account{'new_user'}[$try_count]{'name'}/mg;
        $script_copy =~ s/P_A_S_S-W_O_R_D/$account{'new_user'}[$try_count]{'password'}/mg;
        $script_copy =~ s/A_C_C_O_U_N_T-N_A_M_E/$account{'new_user'}[$try_count]{'account_name'}/mg;
         
        # if you copy/paste/rename a java file, have to rename the class in script to agree with filename!
        #
        my $ocn = $fn;
        $ocn =~ s#.*/##;
        $ocn =~ s/\.java//;
        my $cn = $ofn;
        $cn =~ s#.*/##;
        $cn =~ s/\.java//;
        $script_copy =~ s/$ocn/$cn/mg;
    
        print OUT $script_copy;
        close(OUT);
        # 0 is valid, so increment it after using it...
        $try_count++;
       
    } 
  }
}
