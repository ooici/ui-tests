#!/usr/bin/perl
#
# Site specific customizations section
my $sg_server = "sg-hub.oceanobservatories.org";
#my $target_base = "http://67.58.40.163:3000/";
my $target_base = "http://ion-beta.oceanobservatories.org/";

my %browser;
   $browser{'Windows7'} 		= ['IE', 'Firefox'];
   $browser{'Windows XP'} 		= ['IE', 'Firefox'];
   $browser{'Windows Vista'} 	= ['IE', 'Firefox'];
   $browser{'Linux'} 			= ['Firefox'];
   $browser{'OS X'} 			= ['Safari', 'Firefox'];

   my $generic_password = 'zootester63'; 
   my %account;
   $account{'new_user'}[0]{'name'} = 'zootester63';
   $account{'new_user'}[0]{'password'} = $generic_password;
   $account{'new_user'}[0]{'account_name'} = 'Zoo Test1';

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
  
        # Modify the command to work without selenium grid setu
        my $platform = "$browser{$f}[$i] on $f";
        my $sg_server = "sg-hub.oceanobservatories.org";
        my $target_base = "http://ion-beta.oceanobservatories.org/";
     
        $script_copy =~ s/selenium = new DefaultSelenium\("([^"]+)", 4444, "([^"]+)", "([^"]+)"\);/selenium = new DefaultSelenium("$sg_server", 4444, "$platform", "$target_base");/m;
  
        # Now edit-in the new username and password 
        $script_copy =~ s/U_S_E_R-N_A_M_E/$account{'new_user'}[0]{'name'}/mg;
        $script_copy =~ s/P_A_S_S-W_O_R_D/$account{'new_user'}[0]{'password'}/mg;
        $script_copy =~ s/A_C_C_O_U_N_T-N_A_M_E/$account{'new_user'}[0]{'account_name'}/mg;
         
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
